package com.example.SpringBoot_project1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByJoinedTrue();

	List<Employee> findBySalaryGreaterThanEqual(double salary);

	List<Employee> findByNameAndMobile(String name, long mobile);
	
	List<Employee> findByGender(String gender);
	
	List<Employee> findByName(String name);
	
	List<Employee> findByMobile(long mobile);
	
	List<Employee> findById(int id);

	List<Employee> findByExperienceBetween(int minExperience, int maxExperience);

}
