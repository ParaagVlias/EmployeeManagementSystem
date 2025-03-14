package com.example.SpringBoot_project1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyController {
	
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/")
	public String load() {
		return "index.html";
	}
	
	@GetMapping("/save")
	public String loadSave() {
		return "save.html";
	}
	
	@PostMapping("/save")
	public String save(Employee employee) {
		repository.save(employee);
		return "redirect:/";
	}
	
	@GetMapping("/joined")
	public String joined(Model model) {
		List<Employee> employees = repository.findByJoinedTrue();
		model.addAttribute("employees", employees);
		return "display.html";
	}
	
	@GetMapping("/greater")
	public String loadGreaterForm() {
		return "greater.html";
	}
	
	@PostMapping("/greater")
	public String greater(@RequestParam double salary,Model model) {
		List<Employee> employees = repository.findBySalaryGreaterThanEqual(salary);
		model.addAttribute("employees", employees);
		return "display.html";
	}
	
	@RequestMapping("/fetch")
	public String fetch(Model model) {
		List<Employee> list=repository.findAll();
		model.addAttribute("list", list);
		return "fetch.html";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id,Model model) {
		repository.deleteById(id);
		model.addAttribute("pass", "Deleted Product Success");
		return "fetch";
	}
	
	@GetMapping("/namemobile")
	public String loadByNameAndMobileForm() {
		return "namemobile.html";
	}
	
	@PostMapping("/namemobile")
	public String loadByNameAndMobile(@RequestParam String name,@RequestParam long mobile,Model model) {
		List<Employee> employees = repository.findByNameAndMobile(name,mobile);
		model.addAttribute("employees", employees);
		return "display.html";
	}
	
	@GetMapping("/findbyid")
	public String fetchByIdForm() {
		return "findbyid.html";
	}
	
	@PostMapping("/findbyid")
	public String fetchById(@RequestParam int id, Model model) {
	    List<Employee> employee = repository.findById(id); 
		model.addAttribute("employees", employee);
	    return "display.html"; 
	}
	
	@RequestMapping("/femaleemployees")
	public String fetchFemaleEmployees(Model model) {
	    List<Employee> femaleEmployees = repository.findByGender("female"); 
	    model.addAttribute("employees", femaleEmployees);
	    return "display.html"; 
	}
	
	@GetMapping("/findbyname")
	public String fetchByNameForm() {
		return "findbyname.html";
	}
	
	@PostMapping("/findbyname")
	public String fetchByName(@RequestParam String name, Model model) {
	    List<Employee> employees = repository.findByName(name);
	    model.addAttribute("employees", employees);
	    return "display.html"; 
	}

	@GetMapping("/findbymobile")
	public String fetchByMobileForm() {
		return "findbymobile.html";
	}
	
	@PostMapping("/findbymobile")
	public String fetchByMobile(@RequestParam long mobile, Model model) {
	    List<Employee> employees = repository.findByMobile(mobile);
	    model.addAttribute("employees", employees);
	    return "display.html"; 
	}
	
	@GetMapping("/findexperience")
	public String fetchexperienceForm() {
		return "findexperience.html";
	}
	
	@PostMapping("/findexperience")
	public String fetchExperience(@RequestParam int experience, Model model) {
	    int minExperience = experience - 2; 
	    int maxExperience = experience + 2; 
	    
	    List<Employee> employees = repository.findByExperienceBetween(minExperience, maxExperience);
	    model.addAttribute("employees", employees);
	    return "display.html"; 
	}

}
