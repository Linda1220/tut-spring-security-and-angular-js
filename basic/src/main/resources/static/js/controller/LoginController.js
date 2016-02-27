var app = angular.module("myapp");


app.controller("LoginController",['CookieService','$location', '$http', '$scope', "$rootScope", 'APP_CONSTANT', function(CookieService, $location, $http, $scope, $rootScope, APP_CONSTANT){

    $scope.user = {};
    $scope.login = function(credential) {
      $http.post('/login', $.param(credential),
      { headers : { 'Content-Type': 'application/x-www-form-urlencoded', 'Accept': 'text/html,application/xhtml+xml,application/xml;'}}).then(function(value){
         if (value.data.authenticated) {
            CookieService.createCookie(APP_CONSTANT.USERNAME_COOKIE, value.data.principal.username, 1);
            $rootScope.username = CookieService.getCookie(APP_CONSTANT.USERNAME_COOKIE);
             $location.path("/");
         }
      }, function(err) { console.log(err)});
    };


    function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }

}])