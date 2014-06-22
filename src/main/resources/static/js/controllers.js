var appControllers = angular.module('appControllers', []);

appControllers.controller('PersonsController', function ($scope, $location, Restangular) {

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

    $scope.editPerson = function(person) {
        $location.path("/person/" + person.id);
    };

    function refreshPersons() {
        var personsUrl = Restangular.all('persons');
        personsUrl.getList().then(function(persons) {
            $scope.persons = persons;
        });
    }

});

appControllers.controller('PersonController', function($scope, $location, $routeParams, Restangular) {

    Restangular.one('persons', $routeParams.id).get().then(function(person) {
        $scope.person = person;
        $scope.title = person.firstName + " " + person.name;
    })

    $scope.reset = function() {
        $location.path("/");
    }

    $scope.update = function(person) {
        person.put();
        $location.path("/");
    }
});