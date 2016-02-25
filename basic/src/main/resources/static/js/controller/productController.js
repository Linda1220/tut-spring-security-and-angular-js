var app = angular.module("myapp");

app.controller("ProductController",["$scope", "$http", "$uibModal", "$log", function($scope, $http, $uibModal, $log){
    var fetchAllProducts = function(){
    $http({
        method: "GET",
        url: "/products"
    }).then(function(response){
        $scope.products = response.data;
    });
    };
    var newProduct = {brand: "test", name: "test", price1: "11", price2: "", price3: "", version: "1", weight: "150", provider1: "test", provider2: "", provider3: ""};
    $scope.createProduct = function(newProduct){
        $http({
            method: "PUT",
            url: "/product",
            data: newProduct
        }).then(function(response){
            fetchAllProducts();
        });
    };

    $scope.deleteProduct = function(){
        $http({
            method: "DELETE",
            url: "/product",
            data: $scope.selectedProduct
        }).then(function(response){
            fetchAllProducts();
        });
    };
    $scope.updateProduct = function(){
        $http({
            method: "POST",
            url: "/product",
            data: $scope.selectedProduct
        }).then(function(response){
            fetchAllProducts();
        });
    };
    $scope.open = function(isNew) {

        var waitToOpenProduct = null;
        if (isNew) {
            waitToOpenProduct = angular.copy(newProduct);
        } else {
            waitToOpenProduct = $scope.selectedProduct;
        }


        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'partial/product.html',
            controller: 'ProductDetailCtrl',
            size: null,
            resolve: {
                product: function () {
                  return waitToOpenProduct;
                }
            }
        });

        modalInstance.result.then(function (newProduct) {
            console.log(newProduct);
            if (newProduct.id) {
                  for (var index in $scope.products) {
                           var oldProduct = $scope.products[index];
                              if (oldProduct.id == newProduct.id) {
                                  oldProduct = newProduct;
                                  $scope.updateProduct(oldProduct);
                              }
                          }
            } else {
                 $scope.createProduct(newProduct);
            }

            }, function () {
              $log.info('Modal dismissed at: ' + new Date());
            });
    };

    $scope.selectedProduct = null;
    $scope.setSelectedProduct = function (product) {
       $scope.selectedProduct = product;
    };

    fetchAllProducts();

}]);


app.controller("ProductDetailCtrl", function ($scope, $uibModalInstance, product){
      $scope.newProduct = product;

      $scope.ok = function () {
        $uibModalInstance.close($scope.newProduct);
      };

      $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
      };

});