var app = angular.module("myapp");

app.controller("LoginController",['$location', '$http', '$scope', function($location, $http, $scope){

    $scope.login = function(credential) {
      $http.post('/login', $.param(credential),
      { headers : { 'Content-Type': 'application/x-www-form-urlencoded', 'Accept': 'text/html,application/xhtml+xml,application/xml;'}}).then(function(value){
         console.log(value);
      }, function(err) { console.log(err)});
    };


    function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }

}])