package com.mbms.service;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.exceptions.InvalidLoginException;
import com.mbms.model.Company;
import com.mbms.model.Coupon;
import com.mbms.model.CouponCaregory;
import com.mbms.model.Customer;
import com.mbms.repository.CompanyRepository;
import com.mbms.repository.CouponRepository;
import com.mbms.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CompanyRepository companyRepository;


	private String adminName= "admin";

	private String adminPassword= "1234";

	
	@Override
	public boolean performLogin(String name, String password) throws InvalidLoginException {
		if (adminName.equals(name) && adminPassword.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public boolean checkIfCompanyNameAlreadyExists(String companyName) {
		if (companyRepository.findByName(companyName) != null) {
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public Company insertCompany(Company company) throws CouponSystemException {
		if (checkIfCompanyNameAlreadyExists(company.getName()) == false) {
			companyRepository.save(company);
			return company;
		} else {
			throw new CouponSystemException(
			"Company with the name " + company.getName() + " already exists. Plaease chose other name.");
		}
	}

	@Transactional
	@Override
	public void removeCompany(int companyId) throws CouponSystemException {
		if (companyRepository.findById(companyId).isPresent()) {
			this.companyRepository.deleteCompanyById(companyId);
		} else {
			throw new CouponSystemException("company" + companyId + "was delated");
		}
	}

	@Transactional
	@Override
	public void updateCompany(Company company) throws CouponSystemException {
		if (companyRepository.findById(company.getId()).isPresent()) {
			Company origenCompany = companyRepository.findById(company.getId()).get();
			if (origenCompany.getName().equals(company.getName())) {
				companyRepository.save(company);
				
			} else {
				throw new CouponSystemException("the Company"+ company.getId()+ "cant be updated");
			}
		}
		}

	@Override
	public Company getCompanyById(int companyId) throws CouponSystemException {
		if (companyRepository.findById(companyId).isPresent()) {
			return companyRepository.findById(companyId).get();
		} else {
			throw new CouponSystemException ("there is no company by this id"+ companyId );
		}
	}

	@Override
	public Collection<Company> getAllComapnies() {
		return companyRepository.findAll();
	}

	@Override
	public List<Coupon> getCompanyCoupons(int companyId) throws CouponSystemException {
		if (companyRepository.findById(companyId).isPresent()) {
			return couponRepository.findByCompanyId(companyId);
		} else {
			throw new CouponSystemException("there is no company by this id" + companyId);
		}
	}

	//Customer
	
	@Override
	public boolean checkIfCustomerNameAlreadyExists(String customerName) {
		if (customerRepository.findByName(customerName) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Customer insertCustomer(Customer customer) throws CouponSystemException {
		if (checkIfCustomerNameAlreadyExists(customer.getName()) == false) {
			customerRepository.save(customer);
			return customer;
		} else {
			throw new CouponSystemException(
					"Customer with the name " + customer.getName() + " already exists. Plaease try other name.");
		}
	}

	@Override
	public void removeCustomer(int customerId) throws CouponSystemException {
		if (customerRepository.findById(customerId).isPresent()) {
			customerRepository.delete(customerRepository.findById(customerId).get());
		} else {
			throw new CouponSystemException("Customer number"+ customerId+ "cannot be remove");
		}
	}

	@Transactional
	@Override
	public void updateCustomer(Customer customer) throws CouponSystemException {
		if (customerRepository.findById(customer.getId()).isPresent()) {
			Customer customersave = customerRepository.findById(customer.getId()).get();
			if (customersave.getName().equals(customer.getName())) {
				customerRepository.save(customer);
			} else {
				throw new CouponSystemException("Customer name can not be updated"+ customer.getId());
			}}
	}
	
	@Override
	public Customer getCustomerById(int customerId) throws CouponSystemException {
		if (customerRepository.findById(customerId).isPresent()) {
			return customerRepository.findById(customerId).get();
		} else {
			throw new CouponSystemException("there is no Customer with this id "+customerId );
		}
	}

	@Override
	public Collection<Customer> getAllCustomer()  {
		return customerRepository.findAll();
	}

	@Override
	public List<Coupon> getCustomerCoupons(int customerId) throws CouponSystemException {
		if (customerRepository.findById(customerId).isPresent()) {
			return customerRepository.findById(customerId).get().getCoupons();
		} else {
			throw new CouponSystemException("there is no coupon with this customer id "+ customerId);
		}
	}

	
	}





