var obj = angular.module('myApp', []);

obj.controller("limitController", function($scope) {

	$scope.uid = "";
	$scope.pwd = "";

	$scope.message = "";
	$scope.str = "black";

	$scope.login = function() {

		if ($scope.uid == "shree6791" && $scope.pwd == "123456") {
			$scope.message = "Welcome to Admin";
			$scope.str = "Green";
		} else {
			$scope.message = "invalid userid or password";
			$scope.str = "Red";
		}
	}

});