package com.mbms.service;


import java.util.Collection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.model.Coupon;
import com.mbms.model.CouponCaregory;
import com.mbms.model.Customer;


public interface CustomerService {


	 boolean performLogin(@ NotNull String name,@NotNull String password);
	
	void purchaseCoupon(@Positive int couponId,@Positive int customerId) throws  CouponSystemException;

	Collection<Coupon> getAllCoupons();
	
	Coupon getCouponById(@Positive int id) throws CouponSystemException;

	Customer getCustomer(@Positive int customerId) throws  CouponSystemException;
	
	Collection<Coupon> getAllCustomerCoupons(@Positive int customerId) throws  CouponSystemException;	

	Customer getCustomerByName(String name) throws CouponSystemException;

	boolean checkIfCustomerAlraedyPurchasedCoupon(int customerId, int couponId );
	
	
	Collection<Coupon> getCouponByCategory(@NotNull int customerId,CouponCaregory category);
	
	Collection<Coupon> getCouponLowerThanPrice(@Positive int customerId, double price); 
	
}