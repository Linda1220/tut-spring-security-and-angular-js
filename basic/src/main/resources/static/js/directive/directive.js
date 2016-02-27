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
              return $http.post("/validator/duplicatedUsername", {value: viewValue}).then(function(response){
                  if (!response.data.valid) {
                      return $q.reject(response.data.errorMessage);
                  }
                  return true;
              });
         };

      }
  }
});

app.directive('existedEmail', function($http, $q) {
  return {
      restric: 'A',
      require: '?ngModel',
      link: function (scope, elm, attrs, ctrl) {
         if (!ctrl) return;


         ctrl.$asyncValidators.existedEmail = function(modelValue, viewValue) {
              return $http.post("/validator/existedEmail", {value: viewValue}).then(function(response){
                  if (!response.data.valid) {
                      return $q.reject(response.data.errorMessage);
                  }
                  return true;
              });
         };

      }
  }
});
