var app = angular.module("myapp");

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

app.directive('duplicatedUsername', function($http, $q) {
  return {
      restric: 'A',
      require: '?ngModel',
      link: function (scope, elm, attrs, ctrl) {
         if (!ctrl) return;

         ctrl.$asyncValidators.duplicatedUsername = function(modelValue, viewValue) {
              return $http.post("/validator/duplicatedUsername", {username: viewValue}).then(function(response){
                  console.log(response.data.duplicatedUsername);
                  if (response.data.duplicatedUsername) {
                      return $q.reject(response.data.errorMessage);
                  }
                  return true;
              });
         };


      }
  }
});
