package com.mbms.repository;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mbms.model.Coupon;
import com.mbms.model.CouponCaregory;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	Coupon findByTitle(String title);

	List<Coupon> findByCompanyId(int companyId);

	Collection<Coupon> findByCategory(CouponCaregory category);

	Collection<Coupon> findByPriceLessThan(double price);

	Collection<Coupon> findByEndDateBefore(Date date);

	@Query("select c from Coupon c where c.id = ?1  AND  c.company.id = ?2")
	Coupon getCouponCompany(int couponId, int companyId);

	@Query("SELECT DISTINCT c FROM Coupon c INNER JOIN c.customers t where t.id = ?1")
	Collection<Coupon> couponsCustomerByCustomerId(int customerId);

	@Query("SELECT DISTINCT c FROM Coupon c INNER JOIN c.customers t where t.id = ?1 and c.id = ?2")
	Coupon couponByCustomerIdAndCouponId(int customerId, int couponId);
}