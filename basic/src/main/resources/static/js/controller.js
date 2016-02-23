var user = angular.module("user");

user.controller("DefaultController", function($scope){

   $scope.name = "test";
   $scope.username = "keyang";
});

user.controller("UserController",["$scope", "$http", function($scope, $http){

   var fetchAllUsers = function(){
       $http({
         method: "GET",
         url: "/users"
       }).then(function(response){
          $scope.users = response.data;
       });
   };

   $scope.newuser = {email:"keyang@gmail.com", name:"test", password:"111111"};


   $scope.createUser = function(newuser){

       $http({
         method: "PUT",
         url: "/user",
         data:{
           "email": newuser.email,
           "name": newuser.name,
           "password": newuser.password
         }
       }).then(function(response){

          fetchAllUsers();
       });
   }

   fetchAllUsers();

}]);

user.controller("ProductController",["$scope", "$http", "$uibModal", "$log", function($scope, $http, $uibModal, $log){
    var fetchAllProducts = function(){
    $http({
        method: "GET",
        url: "/products"
    }).then(function(response){
        $scope.products = response.data;
    });
    };
    $scope.newProduct = {brand: "", name: "", price1: "", price2: "", price3: "", version: "", weight: "", provider1: "", provider2: "", provider3: ""};
    $scope.createProduct = function(newProduct){
        $http({
            method: "PUT",
            url: "/product",
            data: newProduct
        }).then(function(response){
            fetchAllProducts();
        });
    }

    $scope.open = function(product) {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'partial/product.html',
            controller: 'ProductDetailCtrl',
            size: null,
            resolve: {
                product: function () {
                  return product;
                }
            }
        });

        modalInstance.result.then(function (newProduct) {
            for (var product in $scope.products) {
                if (product.id == newProduct.id) {
                    product = newProduct;

                }
            }
            }, function () {
            $log.info('Modal dismissed at: ' + new Date());
            });
    };


    fetchAllProducts();

}]);



user.controller("ProductDetailCtrl", function ($scope, $uibModalInstance, product){
      $scope.newProduct = product;

      $scope.ok = function () {
        $uibModalInstance.close($scope.newProduct);
      };

      $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
      };

});