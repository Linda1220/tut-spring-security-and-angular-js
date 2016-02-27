var app = angular.module("myapp");

app.controller("RegisterController",['UserService', '$location', '$rootScope', "$scope",  function(UserService, $location, $rootScope, $scope){
    $scope.register = function() {};

    $scope.user = {username:"test", firstName:"test", lastName:"test", email:"keyang@gmail.com", password:"test"};

    $scope.register = function () {
        UserService.Create($scope.user)
            .then(function (response) {
                console.log(response);
                if (response.status == "OK") {
                    $location.path('/');
                }
            });
    }

}]);
