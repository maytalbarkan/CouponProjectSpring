package com.mbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbms.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Company findByNameAndPassword(String name, String password);

	void deleteCompanyById(int companyId);

	Company findByName(String name);

}