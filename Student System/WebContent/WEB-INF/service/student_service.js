'use strict';

angular.module('studentApp').factory('StudentService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/Student_System/rest';
 
    var factory = {        
        
		addStudent: addStudent,
        updateStudent:	updateStudent,
        
        getStudent:	getStudent,
        getAllStudents: getAllStudents,
                
        deleteStudent:	deleteStudent,
        deleteAllStudents: deleteAllStudents
        
    };
 
    return factory;
    
    // Add Student
    
    function addStudent(student) {
        
    	var deferred = $q.defer();

    	$http.post(REST_SERVICE_URI+'/student/add', student)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Student');
                deferred.reject(errResponse);
            }
        );
        
        return deferred.promise;
    }
 
    // Update Student
    
    function updateStudent(student, id) {
    	
 
    	var deferred = $q.defer();
        
    	$http.put(REST_SERVICE_URI+'/student/'+id, student)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Student');
                deferred.reject(errResponse);
            }
        );
        
    	return deferred.promise;
    }
    
    // Fetch Student Detail
    
    function getStudent(id) {
        
    	var deferred = $q.defer();
        
    	$http.get(REST_SERVICE_URI+'/student/'+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Student');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    // Fetch All Student Details
    
    function getAllStudents() {
        
    	var deferred = $q.defer();
        
    	$http.get(REST_SERVICE_URI+'/students' )
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Students');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    // Delete Student

    function deleteStudent(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+'/student'+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Student');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    // Delete All Students

    function deleteAllStudents() {
        
    	var deferred = $q.defer();
        
    	$http.delete(REST_SERVICE_URI+'/student/deleteAll')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Students');
                deferred.reject(errResponse);
            }
        );
        
    	return deferred.promise;
    }
 
}]);
