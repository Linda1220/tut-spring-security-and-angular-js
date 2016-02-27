var app = angular.module("myapp");

app.controller("ProductListController",["$scope", "$http", "$uibModal", "$log", function($scope, $http, $uibModal, $log){
    $scope.currentPage = 0;
    // max items per page
    $scope.pageSize = 32;
    // number of pagination buttons to display
    $scope.numberButtons = 5;
    // total items in the array
    $scope.totalItems = 0;
    // number of pages
    $scope.numberPages = 0
 }]);