'use strict';

angular.module('greenWebApp')
  .controller('MainCtrl', function ($scope, $http) {

    $scope.getReciepts = [];
    $scope.getProducts = [];


    $scope.addThing = function() {
      if($scope.newThing === '') {
        return;
      }
      $http.post('/api/things', { name: $scope.newThing });
      $scope.newThing = '';
    };

    $scope.deleteThing = function(thing) {
      $http.delete('/api/things/' + thing._id);
    };


    $http.get('/api/receipts')
    .success(function(reciepts){
      $scope.getReciepts = reciepts;
      console.log('Kvittots id ' + reciepts[0]._id);

      $http.get('/api/products')
      .success(function(products){
        $scope.getProducts = products;
        console.log('Produktens id '+products[0]._id);

        $http.put('/api/receipts/' + $scope.getReciepts[0]._id,
        {
          products: $scope.getProducts[0]._id
        })
        .success(function(reciepts){
          console.log("Hej det funkar");
        })
        .error(function(){});

      })
      .error(function(){});

    })
    .error(function(){});


  });
