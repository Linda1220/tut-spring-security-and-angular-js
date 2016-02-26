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
      controllerAs: 'vm'
   });
}).config(function($httpProvider){
    $httpProvider.defaults.headers.common.Accept = 'application/json';
    $httpProvider.defaults.headers.delete = { 'Content-Type': 'application/json'};


    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }
})
