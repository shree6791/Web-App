'use strict';

angular
		.module('studentApp')
		.controller(
				'StudentController',
				[
						'$scope',
						'StudentService',
						function($scope, StudentService) {

							var self = this;

							self.students = [];
							self.student = {
								id : null,
								firstName : '',
								lastName : '',
								email : ''
							};

							self.addStudent = addStudent;
							self.updateStudent = updateStudent;
							self.deleteStudent = deleteStudent;
							self.getAllStudents = getAllStudents

							self.reset = reset;

							getAllStudents();

							// Add Student
							function addStudent(student) {
								
								StudentService
										.addStudent(student)
										.then(
												getAllStudents,
												function(errResponse) {
													console
															.error('Error while creating Student');
												});
								
							}

							// Update Student
							function updateStudent(student, id) {

								StudentService
										.updateStudent(student, id)
										.then(
												getAllStudents,
												function(errResponse) {
													console
															.error('Error while updating Student');
												});

							}

							// Get All Students
							function getAllStudents() {

								StudentService
										.getAllStudents()
										.then(
												function(d) {
													self.students = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Students');
												});

							}

							// Delete Student
							function deleteStudent(id) {

								StudentService
										.deleteStudent(id)
										.then(
												getAllStudents,
												function(errResponse) {
													console
															.error('Error while deleting Student');
												});

							}

							// Submit Student Data
							
						    function submit() {
						        if(self.user.id===null){
						            console.log('Saving New Student', self.student);
						            addStudent(self.student);
						        }else{
						            updateUser(self.student, self.student.id);
						            console.log('Student Details Updated ', self.student.id);
						        }
						        reset();
						    }
						    
						    
							// Clear Form
							function reset() {
								self.student = {
									id : null,
									firstName : '',
									lastName : '',
									email : ''
								};
								$scope.studentForm.$setPristine(); // reset Form
							}

						} ]);
