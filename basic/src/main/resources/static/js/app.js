var user = angular.module("user", ["ngRoute", "ngAnimate", "ui.bootstrap"]);

user.config(function($routeProvider){
   $routeProvider.when("/users", {
     templateUrl: "partial/users.html",
     controller: "UserController"
   }).when("/", {
      templateUrl: "partial/default.html",
      controller: "DefaultController"
   }).when("/products",{
      templateUrl: "partial/products.html",
      controller: "ProductController"
   });
});
