package com.dihaw;

import org.springframework.cache.annotation.Cacheable;



public class Employee {
	
	@Cacheable("emp") 
	public String getEmployee(int empId){
		System.out.println("execute method..");
		if(empId==1){			
			return "Empl 1";
		}else{
			return "Empl 2";
		}
	}
	

}
