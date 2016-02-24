var app = angular.module("myapp");

app.directive("myCustomer", function(){

   return {
      templateUrl: "directiveTemplates/default.html"
   }
});
/*
app.directive('validRepeatpassword', function () {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            ctrl.$parsers.unshift(function (viewValue, $scope) {
                var noMatch = viewValue != scope.myForm.password.$viewValue
                ctrl.$setValidity('noMatch', !noMatch)
            })
        }
    }
});
*/