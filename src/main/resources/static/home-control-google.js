// This is the version used for the HTML home-ajs.html with AngularJS
// This is the trending technology
var rideshareApp = angular.module('rideshareApp', ["firebase"]);

rideshareApp.directive('loginForm', function(){
	return {
		restrict: 'E',
		templateUrl: "login-form.html"
	};
});

rideshareApp.directive('displayForm', function(){
	return {
		restrict:'E',
		templateUrl: "display-form.html"
	};
});

rideshareApp.controller('UserCtrl', function ($scope, $http, $firebaseArray) {
	
	  $scope.tab = 1;

	  $scope.loadUsers = function() {
	    var ref = new Firebase("https://brilliant-heat-9710.firebaseio.com/Users");
	    // download the data into a local object
	    $scope.users = $firebaseArray(ref);
	  }
	  
	  $scope.checkUser = function(acc) {
		  $scope.login = $firebaseArray(ref.child(acc)).$asObject();
	  }

	  $scope.getUser = function() {
		  
		  $http.get("cs580/user/" + $scope.userIdToSearch)
		  	.success(function(data){
		  		$scope.founduser = data;
		  	});
	  }

	  $scope.addUser = function() {
		  $http.post("cs580/user/" + $scope.new_id + "?name=" + $scope.new_name + "&major=" + $scope.new_major)
		  	.success(function(data){
		  		//$scope.loadUsers();
		  	});
	  }

	  $scope.deleteUser = function(userId) {
		  $http.delete("cs580/user/" + userId)
		  	.success(function(data){
		  		$scope.loadUsers();
		  	});
	  }

	  $scope.loadUsers();

	});