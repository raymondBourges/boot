var app = angular.module('exampleApp', ['restangular']);

app.controller('PersonCtrl', function ($scope, Restangular, token) {

    Restangular.addResponseInterceptor(function (data, operation, what, url, response, deferred) {
        //Restangular ne supporte pas encore HAL (https://github.com/mgonto/restangular/issues/661)
        if (operation === 'getList') {
            var ret = data._embedded[what];
            return ret;
        }
        return data;
    });

    //selfLink a la spring-data-rest
    Restangular.setRestangularFields({
        selfLink: '_links.self.href'
    });

    var personsUrl = Restangular.all('persons');
    personsUrl.getList().then(function(persons) {
        persons[0].remove();
        $scope.persons = persons;
    })

    $scope.remove = function(person) {
        person.remove()
    }

});