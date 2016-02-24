var app = angular.module("myapp", ["ngRoute", "ngAnimate", "ui.bootstrap"]);

app.config(function($routeProvider){
   $routeProvider.when("/register", {
     templateUrl: "partial/register.html",
     controller: "UserController"
   }).when("/", {
      templateUrl: "partial/default.html",
      controller: "DefaultController"
   }).when("/products",{
      templateUrl: "partial/products.html",
      controller: "ProductController"
   });
}).config(function($httpProvider){
    $httpProvider.defaults.headers.common.Accept = 'application/json';
    $httpProvider.defaults.headers.delete = { 'Content-Type': 'application/json'};
})
