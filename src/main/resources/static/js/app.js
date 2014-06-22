var app = angular.module('exampleApp', [
    'restangular',
    'ngRoute',
    'appControllers'
]);

app.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/persons', {
                templateUrl: 'views/persons.html',
                controller: 'PersonsController'
            }).
            when('/person/:id', {
                templateUrl: 'views/person.html',
                controller: 'PersonController'
            }).
            otherwise({
                redirectTo: '/persons'
            });
}]);

app.run(['Restangular', function(Restangular) {

    Restangular.addResponseInterceptor(function (data, operation, what) {
        //Restangular ne supporte pas encore HAL (https://github.com/mgonto/restangular/issues/661)
        if (operation === 'getList') {
            if(data._embedded) {
                return data._embedded[what];
            }
            else {
                return [];
            }
        }
        return data;
    });

    Restangular.setDefaultHeaders({'X-CSRF-TOKEN': token});


    //selfLink a la spring-data-rest
    Restangular.setRestangularFields({
        selfLink: '_links.self.href'
    });
}]);

