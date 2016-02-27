var app = angular.module("myapp", ["ngRoute", "ngAnimate", "ui.bootstrap"]);

app.config(function($routeProvider){
   $routeProvider.when("/register", {
     templateUrl: "partial/register.html",
     controller: "RegisterController",
   }).when("/", {
      templateUrl: "partial/default.html",
      controller: "DefaultController"
   }).when("/products",{
      templateUrl: "partial/products.html",
      controller: "ProductController"
   }).when("/login",{
      templateUrl: "partial/login.html",
      controller: "LoginController",
   });
}).config(function($httpProvider){

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.defaults.headers.common.Accept = 'application/json';
    $httpProvider.defaults.headers.delete = { 'Content-Type': 'application/json'};
}).run(["$rootScope", "CookieService", "APP_CONSTANT", function($rootScope, CookieService, APP_CONSTANT) {
    $rootScope.username = CookieService.getCookie(APP_CONSTANT.USERNAME_COOKIE);

}]).constant('APP_CONSTANT', {
    'USERNAME_COOKIE': "USERNAME_COOKIE"
});
