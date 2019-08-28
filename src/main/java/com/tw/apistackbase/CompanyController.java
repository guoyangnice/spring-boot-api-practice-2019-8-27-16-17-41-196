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
@RequestMapping("/companies")
public class CompanyController {
	
	List<CompanyBean> companyList = new ArrayList<CompanyBean>();
	EmployeeController employeeController = new EmployeeController();

	//获取公司列表
	@GetMapping(path = "/")
    public ResponseEntity<List> getAllCompanies(@RequestBody CompanyBean companyBean) {
		companyList.add(new CompanyBean(1, "alibaba",10001));
		companyList.add(new CompanyBean(2, "tengxun",8100));
		companyList.add(new CompanyBean(3, "badiu",10001));
		companyList.add(new CompanyBean(4, "toutiao",8100));
		companyList.add(new CompanyBean(5, "meituan",10001));
		companyList.add(new CompanyBean(6, "didi",8100));
		companyList.add(new CompanyBean(7, "xiangdao",10001));
		companyList.add(new CompanyBean(8, "tianmei",8100));
		
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
	@GetMapping("/{companyId}/employees")
	public ResponseEntity<List> getOneCompanyAllEmployees(@PathVariable int companyId){
		List<String> employeesNameList  = new ArrayList<String>();
		for(EmployeeBean i : employeeController.getAllEmployees()) {
			if(i.getBelongCompanyId() == companyId) {
				employeesNameList.add(i.getEmployeeName());
			}
		}
		System.out.println(employeesNameList.iterator());
		return ResponseEntity.ok(employeesNameList);
	}
	
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
				companyList.remove(cb);
				return new ResponseEntity(HttpStatus.OK);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
	
	//分页查询：如果page等于1，pageSize等于5，它将公司列表中的数据从索引0返回到索引4。
	@GetMapping("")
	public ResponseEntity<List> getCompanyByPage(@RequestParam int page,@RequestParam int pageSize){
//测试数据
//		companyList.add(new CompanyBean(1, "alibaba",10001));
//		companyList.add(new CompanyBean(2, "tengxun",8100));
//		companyList.add(new CompanyBean(3, "badiu",10001));
//		companyList.add(new CompanyBean(4, "toutiao",8100));
//		companyList.add(new CompanyBean(5, "meituan",10001));
//		companyList.add(new CompanyBean(6, "didi",8100));
//		companyList.add(new CompanyBean(7, "xiangdao",10001));
//		companyList.add(new CompanyBean(8, "tianmei",8100));
		
		List<String> complanyNameList  = new ArrayList<String>();
		int start = page * pageSize;
		int end = page * (pageSize+1)+1;
		for(int i = 0;i < pageSize;i++) {
			complanyNameList.add(companyList.subList(start,end).get(i).getCompanyName());
		}
		return ResponseEntity.ok(complanyNameList);
	}
	
}



