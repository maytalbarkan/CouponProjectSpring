package com.mbms.service;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.exceptions.InvalidLoginException;
import com.mbms.model.Company;
import com.mbms.model.Coupon;
import com.mbms.model.Customer;

import lombok.extern.java.Log;

public interface AdminService {

	//COMPANY
	boolean checkIfCompanyNameAlreadyExists(@NotNull String companyName);
	
	boolean performLogin(@NotNull String name, @NotNull String password) throws InvalidLoginException;
	
	Company insertCompany(@Valid Company company) throws CouponSystemException;
	
	void removeCompany(@Positive int companyId) throws CouponSystemException;
	
	void updateCompany(@Valid Company company) throws CouponSystemException;
	
	Company getCompanyById(@Positive int companyId)throws CouponSystemException;
	
	Collection<Company> getAllComapnies();
	
	List<Coupon> getCompanyCoupons(@Positive int companyId) throws CouponSystemException;

	//CUUSTOMER
	
	Customer insertCustomer(@Valid Customer customer) throws CouponSystemException;

	void removeCustomer(@Positive int customerId) throws CouponSystemException;

	void updateCustomer(@Valid Customer customer)throws CouponSystemException;
	
	Customer getCustomerById(@Positive int customerId) throws CouponSystemException;
	
	Collection<Customer> getAllCustomer();
	
	List<Coupon> getCustomerCoupons(@Positive int customerId) throws CouponSystemException;
	
	boolean checkIfCustomerNameAlreadyExists(@NotNull String customerName);
	
}