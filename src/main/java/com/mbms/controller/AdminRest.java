package com.mbms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.model.Customer;
import com.mbms.service.AdminServiceImpl;

@RestController
@RequestMapping("couponProject/admin")

public class AdminRest  {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	
	@RequestMapping(path = "customer/{id}", method = RequestMethod.GET)
	public Customer getCustomerById(@PathVariable int id, HttpServletRequest request) throws CouponSystemException {
		return adminServiceImpl.getCustomerById(id);
	}
	}
