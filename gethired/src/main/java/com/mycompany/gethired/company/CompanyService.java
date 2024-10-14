package com.mycompany.gethired.company;

import java.util.List;

public interface CompanyService {
	void createCompany(Company company);
	List<Company> findAllCompanies();
	Company findCompanyById(Long id);
	boolean updateCompany(Long id,Company updatedCompany);
	boolean deleteCompany(Long id);
}
