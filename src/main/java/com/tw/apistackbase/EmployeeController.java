package com.tw.apistackbase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	
	//��ȡԱ������
		@GetMapping(path = "/")
	    public ResponseEntity<List> getAllEmployees(@RequestBody EmployeeBean employeeBean) {
			EmployeeController employeeController = new EmployeeController();
			employeeList = employeeController.getAllEmployees();
			
			List<String> employeeName = new ArrayList<String>();
			for(EmployeeBean eb:employeeList) {
				employeeName.add(eb.getEmployeeName());
			}
	        return ResponseEntity.ok(employeeList);
	    }
		//��������
		public List<EmployeeBean> getAllEmployees(){
			employeeList.add(new EmployeeBean(4, "alibaba1", 20, "male", 6000, 1));
			employeeList.add(new EmployeeBean(11, "tengxun2", 19, "female", 7000, 2));
			employeeList.add(new EmployeeBean(17, "alibaba2", 21, "male", 8000, 1));
			employeeList.add(new EmployeeBean(11, "tengxun3", 19, "female", 7000, 2));
			employeeList.add(new EmployeeBean(4, "alibaba4", 20, "male", 6000, 1));
			employeeList.add(new EmployeeBean(11, "tengxun5", 19, "female", 7000, 2));
			employeeList.add(new EmployeeBean(4, "alibaba6", 20, "male", 10000, 1));
			employeeList.add(new EmployeeBean(11, "tengxun6", 19, "female", 7000, 2));
			
			return employeeList;
		}
		
		//��ȡĳ��Ա��
		@GetMapping(path = "/{id}")
	    public ResponseEntity<EmployeeBean> getOneEmployee(@PathVariable int id) {
			for(EmployeeBean eb : employeeList) {
				if(eb.getId() == id) {
					return ResponseEntity.ok(eb);
					}
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	    }
		
		//���һ��Ա��
		@PostMapping("/")
		@ResponseStatus(HttpStatus.CREATED)
		public EmployeeBean addEmployee(@RequestBody EmployeeBean employeeBean) {
			employeeList.add(employeeBean);
			return employeeBean;
		}
		
		//������������Ա��
		@PutMapping("/{id}")
		public ResponseEntity<EmployeeBean> updateEmployee(@PathVariable int id) {
			for(EmployeeBean eb : employeeList) {
				if(eb.getId() == id) {
					eb.setAge(30);
					eb.setGender("male");
					return ResponseEntity.ok(eb);
				}
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		//ɾ��һ��Ա��
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<EmployeeBean> deleteOneEmployee(@PathVariable int id){
			for(EmployeeBean eb : employeeList) {
				if(eb.getId() == id) {
					employeeList.remove(eb);
					return new ResponseEntity(HttpStatus.OK);
				}
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		//#��ҳ��ѯ��page����1��pageSize����5
		@GetMapping("")
		public ResponseEntity<List> getEmployeeByPage(@RequestParam int page,@RequestParam int pageSize){
			
			List<String> employeeNameList = new ArrayList<String>();
			int start = page * pageSize;
			int end = page * (pageSize+1)+1;
			for(int i = 0;i < pageSize;i++) {
				employeeNameList.add(employeeList.subList(start,end).get(i).getEmployeeName());
			}
			return ResponseEntity.ok(employeeNameList);
		}
		
		//��ѯ��������Ա��
		@GetMapping("/ee")
		public ResponseEntity<List> getMaleEmployee(@RequestParam String gender){
			List<String> employeeNameList  = new ArrayList<String>();
			for(EmployeeBean eb : employeeList) {
				if(eb.getGender().equals(gender)) {
					employeeNameList.add(eb.getEmployeeName());
				}
			}
			return ResponseEntity.ok(employeeNameList);
		}
}
