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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	List<CompanyBean> companyList = new ArrayList<CompanyBean>();
	List<EmployeeBean> EmployeeBean = new ArrayList<EmployeeBean>();
	//获取公司列表
	@GetMapping(path = "/")
    public ResponseEntity<List> getAllCompanies(@RequestBody CompanyBean companyBean) {
		companyList.add(new CompanyBean(1, "alibaba",10001));
		companyList.add(new CompanyBean(2, "tengxun",8100));
		
		List<String> companyName = new ArrayList<String>();
		for(CompanyBean cb:companyList) {
			companyName.add(cb.getCompanyName());
		}
        return ResponseEntity.ok(companyName);
    }
	
	//获取特定的公司
	@GetMapping(path = "/{id}")
    public ResponseEntity<CompanyBean> getAllCompanies(@PathVariable int id) {
		for(CompanyBean cb : companyList) {
			if(cb.getId() == id) {
				return ResponseEntity.ok(cb);
				}
			}
			return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
	
	//获取某个公司下的所有员工
	
	
	//添加一个公司
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public CompanyBean addCompany(@RequestBody CompanyBean companyBean) {
		companyList.add(companyBean);
		return companyBean;
	}
	
	//更新一个公司的基本信息
	@PutMapping("/{id}")
	public ResponseEntity<CompanyBean> updateCompany(@PathVariable int id) {
		for(CompanyBean cb : companyList) {
			if(cb.getId() == id) {
				cb.setEmployeeNumber(50000);
				cb.setCompanyName("baidu");
				return ResponseEntity.ok(cb);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	//删除一个公司
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CompanyBean> deleteOneCompany(@PathVariable int id){
		for(CompanyBean cb : companyList) {
			if(cb.getId() == id) {
				cb.setEmployeeNumber(50000);
				cb.setCompanyName("baidu");
				return ResponseEntity.ok(cb);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}



