package com.mbms.service;

import java.util.Collection;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.model.Company;
import com.mbms.model.Coupon;
import com.mbms.repository.CompanyRepository;
import com.mbms.repository.CouponRepository;
import com.mbms.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CouponRepository couponRepository;

	public boolean performLogin(String name, String password) {
		Company company = companyRepository.findByNameAndPassword(name, password);
		if (company == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public void insertCoupon(Coupon coupon, int companyId) throws CouponSystemException {
		if (companyRepository.findById(companyId).isPresent()) {
			if (couponRepository.findByTitle(coupon.getTitle()) == null) {
				Company company = companyRepository.findById(companyId).get();
				coupon.setCompany(company);
				couponRepository.save(coupon);
			} else {
				throw new CouponSystemException("There is already coupon with the title " + coupon.getTitle());
			}
	}}

	@Override
	public void removeCoupon(int couponId, int companyId)
			throws CouponSystemException {
		if (companyRepository.findById(companyId).isPresent() && couponRepository.findById(couponId).isPresent()) {
			Coupon coupon = couponRepository.getCouponCompany(couponId, companyId);
			if (coupon != null) {
				couponRepository.delete(coupon);
			}
		} else {
			throw new CouponSystemException("The coupon" + couponId + "is not exist");
		}
	}

	@Override
	public Coupon updateCoupon(Coupon coupon, int companyId) throws CouponSystemException {

	if ((companyRepository.findById(companyId).isPresent())&& (couponRepository.findById(coupon.getId()).isPresent())) {
		if (couponRepository.findById(coupon.getId()).get().getTitle().toString().equals( coupon.getTitle().toString())) {
			if (couponRepository.getCouponCompany(coupon.getId(), companyId) != null) {
				System.out.println(couponRepository.getCouponCompany(coupon.getId(), companyId));
				coupon.setCompany(companyRepository.findById(companyId).get());
				couponRepository.save(coupon);
				
				} else {
					System.out.println(couponRepository.getCouponCompany(coupon.getId(), companyId));
					throw new CouponSystemException("The coupon" + coupon + "is not exist");
				}
		}}
	return coupon;
	}

	@Override
	public Coupon getCoupon(int couponId, int companyId) throws CouponSystemException {
		Coupon coupon = new Coupon();
		if (couponRepository.findById(couponId).isPresent()) {
			Collection<Coupon> companyCoupons = couponRepository.findByCompanyId(companyId);
			for (Coupon coupi : companyCoupons) {
				if (coupi.getId() != couponId) {
					throw new CouponSystemException("coupon is not exist");
				} coupon= coupi;
			}
		}
		return coupon;
	}

	@Override
	public Company getCompany(int companyId) throws CouponSystemException {
		if (!companyRepository.findById(companyId).isPresent()) {
			throw new CouponSystemException("Company is not exist");
		} else {
			return companyRepository.findById(companyId).get();
		}
	}

	@Override
	public Collection<Coupon> getCompanyCoupons(int companyId) throws CouponSystemException {
		return couponRepository.findByCompanyId(companyId);
	}

	@Override
	public Company getComapnyByName(String name) throws CouponSystemException {
		Company company = companyRepository.findByName(name);
		if (company == null) {
			throw new CouponSystemException("Company is not exist");
		}
		return company;
	}



}