package com.mbms.service;
import java.util.Collection;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.model.Coupon;
import com.mbms.model.CouponCaregory;
import com.mbms.model.Customer;
import com.mbms.repository.CompanyRepository;
import com.mbms.repository.CouponRepository;
import com.mbms.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public boolean performLogin(String name, String password) {
		Customer customer = customerRepository.findByNameAndPassword(name, password);
		if (customer == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void purchaseCoupon(int couponId, int customerId)throws CouponSystemException {
	// Check if the coupon exists.
		if (couponRepository.findById(couponId).isPresent()) {
			// Check if the customer already purchased this coupon.
			if (!checkIfCustomerAlraedyPurchasedCoupon(customerId, couponId)) {
				Coupon coupon = couponRepository.findById(couponId).get();
				Customer customer = customerRepository.findById(customerId).get();
				// Check if the amount of the coupon bigger then 0.
				if (coupon.getAmount() > 0) {
					// Reduces in 1 amount of coupons
					coupon.setAmount(coupon.getAmount() - 1);
					customer.addCoupon(coupon);
				} else {
					throw new CouponSystemException("the customer is alredy purcech the coupon");
				}
			} 
		}

	}

	@Override
	public Collection<Coupon> getAllCoupons() {
		return couponRepository.findAll();
	}

	@Override
	public Coupon getCouponById(@Positive int id) throws CouponSystemException {
		if (couponRepository.findById(id).isPresent()) {
			return couponRepository.findById(id).get();
		} else {
			throw new CouponSystemException("there is no coupon with this id  "+ id);
		}
	}

	@Override
	public Collection<Coupon> getAllCustomerCoupons(@Positive int customerId) throws CouponSystemException {
		return couponRepository.couponsCustomerByCustomerId(customerId);
	}

	@Override
	public Customer getCustomer(@Positive int customerId) throws CouponSystemException {
		if (customerRepository.findById(customerId).isPresent()) {
			return customerRepository.findById(customerId).get();
		} else {
			throw new CouponSystemException("Customer id number"+ customerId+"is not excist");
		}
	}

	@Override
	public Collection<Coupon> getCouponByCategory(@NotNull CouponCaregory category) {
		return couponRepository.findByCategory(category);
	}

	@Override
	public Collection<Coupon> getCouponLowerThanPrice(@Positive double price) {
		return couponRepository.findByPriceLessThan(price);

	}

	@Override
	public Customer getCustomerByName(@NotBlank String name) throws CouponSystemException {
		Customer customer = customerRepository.findByName(name);
		if (customer == null) {
			throw new CouponSystemException("Customer name"+ name+ "is not excist");
		}
		return customer;
	}

	@Override
	public boolean checkIfCustomerAlraedyPurchasedCoupon(int customerId, int couponId) {
		Coupon coupon = couponRepository.couponByCustomerIdAndCouponId(customerId, couponId);
		if (coupon == null) {
			return false;
		} else {
			return true;
		}
	}

	
	
}