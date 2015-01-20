'use strict';

angular.module('greenWebApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('KvittoSida', {
        url: '/KvittoSida',
        templateUrl: 'app/KvittoSida/KvittoSida.html',
        controller: 'MainCtrl'
      });
  });