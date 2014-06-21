var app = angular.module('exampleApp', ['restangular']);

app.controller('PersonCtrl', function ($scope, $http, Restangular, token) {

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

    refreshPersons();

    $scope.remove = function(person) {
        person.remove().then(function() {
            refreshPersons();
        });
    };

    $scope.addSomePersons = function() {
        Restangular.one('add').post().then(function() {
            refreshPersons();
        });
    };

    function refreshPersons() {
        var personsUrl = Restangular.all('persons');
        personsUrl.getList().then(function(persons) {
            $scope.persons = persons;
        });
    }

});