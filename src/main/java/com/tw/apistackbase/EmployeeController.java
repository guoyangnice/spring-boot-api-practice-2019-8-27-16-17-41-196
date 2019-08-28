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
	List<EmployeeBean> EmployeeBean = new ArrayList<EmployeeBean>();
	
	//获取员工名单
		@GetMapping(path = "/")
	    public ResponseEntity<List> getAllEmployees(@RequestBody CompanyBean companyBean) {
			companyList.add(new CompanyBean(1, "alibaba",10001));
			companyList.add(new CompanyBean(2, "tengxun",8100));
			
			List<String> companyName = new ArrayList<String>();
			for(CompanyBean cb:companyList) {
				companyName.add(cb.getCompanyName());
			}
	        return ResponseEntity.ok(companyName);
	    }
}
