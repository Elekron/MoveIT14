'use strict';

angular.module('greenWebApp')
  .controller('NavbarCtrl', function ($scope, $location, Auth) {
    $scope.menu = [{
      'title': 'Home',
      'link': '/'
    }];

    $scope.isCollapsed = true;
    $scope.isLoggedIn = Auth.isLoggedIn;
    $scope.isAdmin = Auth.isAdmin;
    $scope.getCurrentUser = Auth.getCurrentUser;
    //till
    $scope.isProfilSida = Auth.isProfilSida;
    $scope.getCurrentUser = Auth.getCurrentUser;
     //till
    $scope.isKopSida = Auth.isKopSida;
    $scope.getCurrentUser = Auth.getCurrentUser;
     //till
    $scope.isKvittoSido = Auth.isKvittoSido;
    $scope.getCurrentUser = Auth.getCurrentUser;

    $scope.logout = function() {
      Auth.logout();
      $location.path('/login');
    };

    $scope.isActive = function(route) {
      return route === $location.path();
    };
  });