var app = angular.module("myapp");

app.factory('UserService',['$http',function($http){
    var service = {};

    service.GetAll = GetAll;
    service.GetById = GetById;
    service.GetByUsername = GetByUsername;
    service.GetByEmail = GetByEmail;
    service.Create = Create;
    service.Update = Update;
    service.Delete = Delete;

    return service;

    function GetAll() {
        return $http.get('/users').then(handleSuccess, handleError('Error getting all users'));
    }

    function GetById(id) {
        return $http.get('/user' + id).then(handleSuccess, handleError('Error getting user by id'));
    }

    function GetByUsername(username) {
        return $http.get('/user' + username).then(handleSuccess, handleError('Error getting user by username'));
    }

    function GetByEmail(email) {
        return $http.get('/user' + email).then(handleSuccess, handleError('Error getting user by username'));
    }

    function Create(user) {
        return $http.put('/user', user).then(handleSuccess, handleError('Error creating user'));
    }

    function Update(user) {
        return $http.post('/user' + user.id, user).then(handleSuccess, handleError('Error updating user'));
    }

    function Delete(id) {
        return $http.delete('/user' + id).then(handleSuccess, handleError('Error deleting user'));
    }

    // private functions

    function handleSuccess(res) {
        return res.data;
    }

    function handleError(error) {
        return function () {
            return { success: false, message: error };
        };
    }

}]);
