var app = angular.module("myapp");

app.controller("UserController",["$scope", "$http", "$uibModal", "$log", function($scope, $http, $uibModal, $log){

   var fetchAllUsers = function(){
       $http({
         method: "GET",
         url: "/users"
       }).then(function(response){
          $scope.users = response.data;
       });
   };

   $scope.newUser = {email:"", name:"", password:""};


   $scope.createUser = function(newUser){
       $http({
         method: "PUT",
         url: "/user",
         data: newUser
       }).then(function(response){

          fetchAllUsers();
       });
   }
  $scope.cancel = function () {
       $uibModalInstance.dismiss('cancel');
  };


   fetchAllUsers();

}]);
