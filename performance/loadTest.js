import http from 'k6/http';
import {check, group, sleep} from 'k6';

export let options = {
    stages: [
        {duration: '10s', target: 2},
        {duration: '20s', target: 5},
        {duration: '10s', target: 0},
    ],
    thresholds: {
        http_req_duration: ['p(95)<500'],
        'checks': ['rate>0.95'],
    },
};

const BASE_URL = 'https://thinking-tester-contact-list.herokuapp.com';

export default function () {
    group('GET login page (UI simulation)', () => {
        const res = http.get(`${BASE_URL}/login`);
        check(res, {
            'login page loaded': (r) => r.status === 200 || r.status === 404,
        });
    });

    let token = '';
    group('POST login (API)', () => {
        const payload = JSON.stringify({
            email: 'test@freemail.hu',
            password: 'tesztelek'
        });

        const headers = {'Content-Type': 'application/json'};
        const res = http.post(`${BASE_URL}/users/login`, payload, {headers});

        check(res, {
            'status is 200': (r) => r.status === 200,
            'contains token': (r) => r.json('token') !== '',
        });
        token = res.json('token');
    });

    group('GET /contacts with token', () => {
        const headers = {
            Authorization: `Bearer ${token}`,
            'Content-Type': 'application/json'
        };

        const res = http.get(`${BASE_URL}/contacts`, {headers});

        check(res, {
            'contacts status 200': (r) => r.status === 200,
            'contacts is array': (r) => Array.isArray(r.json()),
        });
    });

    sleep(1);
}