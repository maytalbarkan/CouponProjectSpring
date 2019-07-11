package com.mbms.service;
import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.model.Company;
import com.mbms.model.Coupon;



public interface CompanyService {

	boolean performLogin(String name, String password);

	void insertCoupon(@Valid Coupon coupon, @Positive int companyId) throws CouponSystemException;

	void removeCoupon(@Positive int couponId, @Positive int companyId) throws CouponSystemException;

	Coupon updateCoupon(@Valid Coupon coupon, @Positive int companyId) throws CouponSystemException;

	Coupon getCoupon(@Positive int couponId, @Positive int companyId) throws CouponSystemException;
	
	Company getCompany(@Positive int companyId) throws CouponSystemException;

	Company getComapnyByName(@NotNull String name) throws CouponSystemException;

	Collection<Coupon> getCompanyCoupons(@Positive int companyId) throws CouponSystemException;

	

}