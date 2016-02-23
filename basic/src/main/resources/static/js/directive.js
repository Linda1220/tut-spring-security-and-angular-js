var user = angular.module("user");

user.directive("myCustomer", function(){

   return {
      templateUrl: "directiveTemplates/default.html"
   }
});