package com.mycompany.gethired.company;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	CompanyService companyService;
	
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}

	@GetMapping
	public ResponseEntity<List<Company>> findAll(){
		return new ResponseEntity<>(companyService.findAllCompanies(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> findCompnyById(@PathVariable Long id) {
		if(companyService.findCompanyById(id) !=null)
			return new ResponseEntity<>(companyService.findCompanyById(id), HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		companyService.createCompany(company);
		return new ResponseEntity<>("Company created successfuly", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id ,@RequestBody Company company){
		boolean updated  = companyService.updateCompany(id, company);
		if(updated)
			return new ResponseEntity<>("Company Updated Successfuly", HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id){
		boolean deleted = companyService.deleteCompany(id);
		if(deleted)
			return new ResponseEntity<>("Company Deleted Successfuly", HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
