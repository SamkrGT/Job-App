package com.mycompany.gethired.company;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	CompanyRepository companyRepository;
	
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public void createCompany(Company company) {
		companyRepository.save(company);
	}

	@Override
	public List<Company> findAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public Company findCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public boolean updateCompany(Long id, Company updatedCompany) {
		if(companyRepository.findById(id).isPresent()){
			Company company = companyRepository.findById(id).get();
			company.setAbout(updatedCompany.getAbout());
			company.setName(updatedCompany.getName());
			companyRepository.save(company);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCompany(Long id) {
		if(companyRepository.findById(id).isPresent()) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
