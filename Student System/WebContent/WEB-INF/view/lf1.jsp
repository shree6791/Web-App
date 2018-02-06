
<html>
	<head>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.0-beta.5/angular.min.js"></script>
		<!-- create a web page to sort the student details based on selected column using orderby filter -->
<script>
var obj=angular.module('myApp',[]);
obj.controller("limitController",function($scope)
{
$scope.uid="";
$scope.pwd="";
$scope.message="";
$scope.str="black";
$scope.login=function()
{
if($scope.uid=="admin" && $scope.pwd=="admin")
{
$scope.message="Welcome to Admin";
$scope.str="Green";
}
else
{
$scope.message="invalid userid or password";
$scope.str="Red";

}


}

}
);
</script>
	</head>
 <BODY>
<div ng-app="myApp" ng-controller="limitController">

UserName <input type="text" ng-model="uid"/><br>
PassWord <input type="password" ng-model="pwd"/><br>
<input type="button" ng-click="login()" value="login">
<span style="color:{{str}}">{{message}}</span>
</div>
 </BODY>
</HTML>