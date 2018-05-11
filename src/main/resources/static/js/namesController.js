var app = angular.module('myApp', []);
app.controller('namesCtrl', function($scope) {
    $scope.names = [
        {name:'Jani',country:'Norway'},
        {name:'Hege',country:'Sweden'},
        {name:'Kai',country:'Denmark'}
    ];
    $scope.name = "John Doe";
});
app.controller('namesCtrlTwo', function($scope) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
    $scope.fullName = function() {
        return $scope.firstName + " " + $scope.lastName;
    }
});
var userfy={
    method: 'GET',
    url: '/test/userfy?susu=1'
};

function myfunction($scope, $http) {
    $http(userfy).then(function successCallback(response) {
        $scope.names = response.data.data.datalist;
    }, function errorCallback(response) {
        // 请求失败执行代码
        $scope.names = response;
    });
};
app.controller('userfy', myfunction);