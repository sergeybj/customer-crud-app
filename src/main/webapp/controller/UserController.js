var app = angular.module('myApp', []);

app.controller('myCustomerListCtrl', function($scope, $http) {

	$http.get('customerListAction').success(function(data, status, headers, config) {
		$scope.items = data;
		$scope.json = angular.fromJson(data);
	});
});