'use strict';

angular.module('webappApp')
  .controller('MainCtrl', function ($scope, $http) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $http.get('http://localhost:8080/persons').
    success(function(data) {
        $scope.persons = data;
    });
  });
