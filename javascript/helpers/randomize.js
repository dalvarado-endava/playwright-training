const st = require('../helpers/state');

export function email () {
    return 'fakeMail' + Math.floor(Math.random() * 9999999) + '@mail.com';
}

export function state() {
    let random = Math.floor(Math.random()*(Object.keys(st).length-1)+1);
    return {value: String(random)}
}