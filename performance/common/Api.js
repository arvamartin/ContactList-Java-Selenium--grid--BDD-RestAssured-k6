import http from 'k6/http';
import { check, fail } from 'k6';

const BASE_URL = __ENV.BASE_URL || 'https://thinking-tester-contact-list.herokuapp.com';

export function login(email, password) {
    const payload = JSON.stringify({ email, password });
    const headers = { 'Content-Type': 'application/json' };

    const res = http.post(`${BASE_URL}/users/login`, payload, { headers });

    check(res, {
        'login successful': (r) => r.status === 200,
        'token received': (r) => r.json('token') !== '',
    }) || fail(`Login failed: ${res.status}`);

    return res.json('token');
}

export function getContacts(token) {
    const headers = {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
    };

    const res = http.get(`${BASE_URL}/contacts`, { headers });

    check(res, {
        'contacts fetched': (r) => r.status === 200,
        'response is array': (r) => Array.isArray(r.json()),
    }) || fail(`Contacts fetch error: ${res.status}`);
}
