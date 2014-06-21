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
            when('/person', {
                templateUrl: 'views/person.html',
                controller: 'PersonController'
            }).
            otherwise({
                redirectTo: '/persons'
            });
    }]);