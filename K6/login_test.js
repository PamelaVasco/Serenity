import http from 'k6/http';
import { check, sleep } from 'k6';
import { SharedArray } from 'k6/data';
import papaparse from 'https://jslib.k6.io/papaparse/5.1.1/index.js';

// Configuración de la prueba
export let options = {
    vus: 20, // Usuarios virtuales simultáneos
    duration: '1m', // Duración total de la prueba
    thresholds: {
        http_req_duration: ['p(95)<1500'], // El 95% de las solicitudes deben tardar menos de 1.5 segundos
        http_req_failed: ['rate<0.03'],    // La tasa de error debe ser menor al 3%
    },
};

// Cargar datos desde el archivo CSV
const datosUsuarios = new SharedArray('usuarios', function () {
    return papaparse.parse(open('./users.csv'), { header: true }).data;
});

export default function () {
    // Seleccionar un usuario aleatorio del CSV
    const usuario = datosUsuarios[Math.floor(Math.random() * datosUsuarios.length)];

    // URL del servicio de login
    const url = 'https://fakestoreapi.com/auth/login';

    // Construir el cuerpo de la solicitud en formato JSON
    const cuerpo = JSON.stringify({
        username: usuario.user,
        password: usuario.passwd,
    });

    // Encabezados de la solicitud
    const encabezados = {
        headers: { 'Content-Type': 'application/json' },
    };

    // Enviar la solicitud POST
    let respuesta = http.post(url, cuerpo, encabezados);

    // Validaciones
    check(respuesta, {
        'estado es 200': (r) => r.status === 200,
        'tiempo de respuesta < 1.5s': (r) => r.timings.duration < 1500,
        'token presente': (r) => r.body.includes('token'),
    });

    // Pausa entre iteraciones
    sleep(1);
}