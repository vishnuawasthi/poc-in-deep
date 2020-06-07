package com.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Employee;
import com.app.dto.MasterData;
import com.app.dto.MemberDetail;

@RestController
public class DroolsRuleController {

	@Autowired
	private KieSession kieSession;

	@RequestMapping(value = "/employees",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object validateEmployess(@RequestBody List<Employee> employees) {
		System.out.println("validateEmployess() - start");
		
		 MasterData  masterData = new MasterData( ) ;
		 
		 List<Employee> permanentEmployee = employees.stream().filter(employee->   "PERMANENT".equalsIgnoreCase(employee.getJobType())).collect(Collectors.toList());
		
		 List<Employee> contractEmployee = employees.stream().filter(employee->   "CONTRACT".equalsIgnoreCase(employee.getJobType())).collect(Collectors.toList());
		 masterData.setConstractEmployee(contractEmployee);
		 masterData.setPermanentEmployee(permanentEmployee);
		 
		 masterData.setEmployees(employees);
		// masterData.setEmployees(new ArrayList());
		// masterData.setEmployees(null);
		 
		 
		 Employee empOther = new Employee();
		 empOther.setJobType("OTHER");
		 
		 masterData.getEmployees().stream().forEach(employee->{
			 kieSession.insert(employee);
				// kieSession.insert(empOther);
				 kieSession.fireAllRules();
		 });
		
		System.out.println("validateEmployess() - end");
		return new ResponseEntity<List<Employee>>(masterData.getEmployees(), HttpStatus.OK);
	}

	@RequestMapping(value = "/members",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object memberRules(@RequestBody List<MemberDetail> members) {
		System.out.println("memberRules() - start");
		members.stream().forEach(member->{
			
			     kieSession.insert(member);
				 kieSession.fireAllRules();
		 });
		
		System.out.println("memberRules() - end");
		return new ResponseEntity<List<MemberDetail>>(members, HttpStatus.OK);
	}
}
