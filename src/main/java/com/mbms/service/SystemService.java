package com.mbms.service;

import java.util.Collection;
import java.util.Date;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.exceptions.InvalidLoginException;
import com.mbms.model.Company;
import com.mbms.model.Coupon;
import com.mbms.model.CustomLogin;
import com.mbms.model.Customer;
import com.mbms.model.LoginType;
import com.mbms.repository.CouponRepository;

import lombok.extern.java.Log;


@Service
public class SystemService {

	@Autowired
	private AdminService adminService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CouponRepository couponRepository;

	public CustomLogin login(String name, String password, LoginType loginType)	throws CouponSystemException, InvalidLoginException {
	switch (loginType) {
			case ADMIN:
				if (adminService.performLogin(name, password)) {
					CustomLogin customLogin = new CustomLogin(LoginType.ADMIN, 1);
					return customLogin;
				} else {
					throw new InvalidLoginException();
				}
			case COMPANY:
				if (companyService.performLogin(name, password)) {
					Company company = companyService.getComapnyByName(name);
					return new CustomLogin(LoginType.COMPANY, company.getId());
				} else {
					throw new InvalidLoginException();
				}
			case CUSTOMER:
				if (customerService.performLogin(name, password)) {
					Customer customer = customerService.getCustomerByName(name);
					return new CustomLogin(LoginType.CUSTOMER, customer.getId());
				} else {
					throw new InvalidLoginException();
				}
			default:
				throw new InvalidLoginException();
		}
	}

	/**
	 * This is a daily thrad that work when the system is activated or every 24 hours
	 * The function will get from the DB all expiring, and remove them
	 */
	@Scheduled(fixedRateString = "${coupon.project.remove.daily.coupon.every.day}")
	@Transactional
	public void removeInvalidCoupon() {
		Collection<Coupon> allCoupons = couponRepository.findByEndDateBefore((java.sql.Date) new Date());
		for (Coupon coupon : allCoupons) {
			couponRepository.delete(coupon);
		}
	}
}
	
	
	