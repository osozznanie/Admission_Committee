
const messageResource = (() => {
    let properties = {};
    const DEFAULT_MODULE_NAME = '_default';
    const DEFAULT_EXTENSION = '.properties';
    let filePath;
    let fileExtension;
    let defaultLocale = 'en_US';
    let currentLocale = defaultLocale;
    let fileNameResolver;
    let ajaxFunction;
    let validConfiguration = false;
    let debugMode = false;

    function defaultFileNameResolver(module, locale) {
        return locale && typeof locale === 'string'
            ? `${module}_${locale}`
            : module;
    }

    function saveFile(text, module, locale) {
        text = `${text}`;
        if (!text) {
            throw new Error('Invalid contents.');
        }
        properties = properties || {};
        properties[locale] = properties[locale] || {};
        properties[locale][module] = properties[locale][module] || {};
        const curModuleMap = properties[locale][module];
        const linesArray = text.split('\n');
        linesArray.forEach((line) => {
            line = line.trim();
            if (line === '' || line.charAt(0) === '#') {
                return;
            }
            const keyValPair = line.match(/([^=]*)=(.*)$/);
            if (keyValPair && keyValPair[1]) {
                const value = keyValPair[2] ? keyValPair[2].trim() : '';
                curModuleMap[keyValPair[1].trim()] = value;
            } else {
                throw new Error('Invalid line: ' + line);
            }
        });
    }

    function getValidLocale(locale) {
        if (!locale || typeof locale !== 'string') {
            locale = currentLocale;
        }
        if (locale.indexOf('-') !== -1) {
            locale = locale.replace('-', '_');
        }
        return locale;
    }

    function isModuleLoaded(module, locale) {
        return !!(module && locale && properties && properties[locale] && properties[locale][module]);
    }

    function convertUnicodeString(str) {
        return str.replace(/\\u[\dA-Fa-f]{4}/g, (unicodeChar) =>
            String.fromCharCode(parseInt(unicodeChar.replace(/\\u/g, ''), 16))
        );
    }

    function log(msg, doAlert) {
        if (debugMode && console && console.log) {
            console.log('messageResource.js: ' + msg);
        }
        if (doAlert === true) {
            alert('messageResource.js: ' + msg);
        }
    }

    function ajaxGet(url, callback) {
        const xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4) {
                if (xmlhttp.status === 200) {
                    callback(xmlhttp.responseText);
                } else {
                    callback(xmlhttp.status);
                }
            }
        };
        xmlhttp.open('GET', url, true);
        xmlhttp.send();
    }

    return {
        init: (config) => {
            config = config || {};
            filePath = config.filePath || '';
            if (filePath && filePath.charAt(filePath.length - 1) !== '/') {
                filePath = filePath + '/';
            }
            fileExtension = config.fileExtension || DEFAULT_EXTENSION;
            if (fileExtension.charAt(0) !== '.') {
                fileExtension = '.' + fileExtension;
            }
            defaultLocale = getValidLocale(config.defaultLocale);
            currentLocale = defaultLocale;
            fileNameResolver = config.fileNameResolver || defaultFileNameResolver;
            ajaxFunction = config.ajaxFunction || ajaxGet;
            debugMode = config.debugMode || false;
            validConfiguration = true;
        },

        setCurrentLocale: (locale) => {
            if (locale && typeof locale === 'string') {
                currentLocale = locale;
            }
        },

        load: (module, callback, locale) => {
            if (!validConfiguration) {
                throw new Error('Invalid configuration - Invoke init method with proper configuration');
            }

            const validModule = module || DEFAULT_MODULE_NAME;
            const validLocale = getValidLocale(locale);
            const fileLocale = (validLocale === defaultLocale) ? locale : validLocale;

            const modulesToLoad = Array.isArray(validModule) ? validModule.filter((mod) => !isModuleLoaded(mod, validLocale)) : (!isModuleLoaded(validModule, validLocale) ? [validModule] : []);

            if (modulesToLoad.length === 0) {
                if (callback) {
                    callback();
                }
                return;
            }

            properties = properties || {};
            properties[validLocale] = properties[validLocale] || {};

            let filesLoadedCount = 0;

            modulesToLoad.forEach((modName) => {
                const fileName = fileNameResolver(modName, fileLocale);
                const fileUrl = filePath + fileName + fileExtension;
                ajaxFunction(fileUrl, (text) => {
                    saveFile(text, modName, validLocale);
                    filesLoadedCount += 1;
                    if (filesLoadedCount === modulesToLoad.length) {
                        if (callback) {
                            callback();
                        }
                    }
                });
            });
        },

        get: (key, module, locale, defaultValue) => {
            const validModule = module || DEFAULT_MODULE_NAME;
            const validLocale = getValidLocale(locale);
            const moduleObj = properties[validLocale] && properties[validLocale][validModule];
            const value = (moduleObj && typeof moduleObj[key] !== 'undefined') ? moduleObj[key] : (defaultValue || key);
            return convertUnicodeString(value);
        },
    };
})();

if (typeof define === 'function' && define.amd) {
    define([], () => messageResource);
} else if (typeof global.messageResource === 'undefined') {
    global.messageResource = messageResource;
}
