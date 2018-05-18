var app = angular.module('myApp', []);
app.controller('namesCtrl', function ($scope) {
    $scope.names = [
        {name: 'Jani', country: 'Norway'},
        {name: 'Hege', country: 'Sweden'},
        {name: 'Kai', country: 'Denmark'}
    ];
    $scope.name = "John Doe";
});
app.controller('namesCtrlTwo', function ($scope) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
    $scope.fullName = function () {
        return $scope.firstName + " " + $scope.lastName;
    }
});
var userfy = {
    method: 'GET',
    url: '/test/userfy/1.html'
};
app.controller('userfy', function ($scope, $http) {
    $http(userfy).then(function successCallback(response) {
        $scope.yours = response.data.data.list;
    }, function errorCallback(response) {
        // 请求失败执行代码
        $scope.yours = response.data;
    });

});


