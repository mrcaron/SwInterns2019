'use strict'
var module = angular.module('demo.controllers', []);
module.controller("MethodController", ["$scope", "MethodService",
    function($scope, UserService) {
        $scope.userDto = {
            userId: null,
            userName: null,
            skillDtos: []
        };
        $scope.skills = [];
        UserService.getUserById(1).then(function(value) {
            console.log(value.data);
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });
        ]);