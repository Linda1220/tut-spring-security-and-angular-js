(function(){
  var app = angular.module('store', []);

  app.controller('StoreController', function($http){
    var self = this;
    $http.get('resource/').success(function(data){
        self.greeting = data;
    });
  };
  app.controller("PanelController", function(){
    this.tab = 1;
    this.selectTab = function(setTab){
     this.tab = setTab;
    };
    this.isSelected = function(checkTab){
        return this.tab === checkTab;
    };
  });
app.controller("productController",function(){
    var query="select";
    });
})();