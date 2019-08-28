package com.tw.apistackbase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	
	//获取员工名单
		@GetMapping(path = "/")
	    public ResponseEntity<List> getAllEmployees(@RequestBody EmployeeBean employeeBean) {
			EmployeeController employeeController = new EmployeeController();
			employeeController.getAllEmployees();
			
			List<String> employeeName = new ArrayList<String>();
			for(EmployeeBean eb:employeeList) {
				employeeName.add(eb.getEmployeeName());
			}
	        return ResponseEntity.ok(employeeList);
	    }
		//保存数据
		public List<EmployeeBean> getAllEmployees(){
			employeeList.add(new EmployeeBean(4, "alibaba1", 20, "male", 6000, 1));
			employeeList.add(new EmployeeBean(11, "tengxun2", 19, "female", 7000, 2));
			employeeList.add(new EmployeeBean(17, "alibaba2", 21, "male", 8000, 1));
			employeeList.add(new EmployeeBean(11, "tengxun3", 19, "female", 7000, 2));
			employeeList.add(new EmployeeBean(4, "alibaba4", 20, "male", 6000, 1));
			employeeList.add(new EmployeeBean(11, "tengxun5", 19, "female", 7000, 2));
			employeeList.add(new EmployeeBean(4, "alibaba6", 20, "male", 10000, 1));
			employeeList.add(new EmployeeBean(11, "tengxun6", 19, "female", 7000, 2));
			
			System.out.println(employeeList);
			return employeeList;
		}
}
