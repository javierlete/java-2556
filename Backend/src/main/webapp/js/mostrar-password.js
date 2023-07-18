window.addEventListener('DOMContentLoaded', function() {
	const boton = document.getElementById('mostrar-password');
	const password = document.querySelector('[type=password]');

	boton.addEventListener('click', function() {
		if(password.type === 'text') {
			password.type = 'password';
			boton.innerHTML = '<i class="bi bi-eye"></i>';
		} else {
			password.type = 'text';
			boton.innerHTML = '<i class="bi bi-eye-slash"></i>';
		}
	});
});