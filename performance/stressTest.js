import { login, getContacts } from './Common/API.js';
import { sleep } from 'k6';

export let options = {
    stages: [
        { duration: '30s', target: 10 },
        { duration: '1m', target: 25 },
        { duration: '30s', target: 0 },
    ],
};

export default function () {
    const token = login(__ENV.EMAIL || 'test@freemail.hu', __ENV.PASSWORD || 'tesztelek');
    getContacts(token);
    sleep(1);
}
