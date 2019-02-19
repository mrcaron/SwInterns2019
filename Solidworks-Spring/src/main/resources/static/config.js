function () {
	angular
	.module("UserDemo")
	.config(configuration);

	function configuration($routeProvider,$httpProvider) {

		$httpProvider.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
		$httpProvider.defaults.headers.put['Content-Type'] = 'application/json;charset=utf-8';

		$routeProvider
		.when("/",{
			templateUrl: 'resources/static/home.html',
			controller: 'MethodController',
			controllerAs: 'model'
		})
		.otherwise({
			redirectTo: '/'
		});
	}
})();
