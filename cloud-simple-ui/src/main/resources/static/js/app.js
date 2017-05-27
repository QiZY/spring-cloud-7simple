angular.module('users', ['ngRoute']).config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'user-page.html',
        controller: 'userCtr'
    })
}).controller('userCtr', function ($scope, $http) {
    $http.get('users').then(function (result) {  //正确请求成功时处理
        console.info(result);
        $scope.userList = result.data;
    }).catch(function (result) { //捕捉错误处理
        console.info(result);
        alert(result.data.Message);
    });
});