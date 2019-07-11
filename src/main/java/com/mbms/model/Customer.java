package com.mbms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;


@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Basic(optional = false)
	@Column(nullable = false)
	private String name;
	@Basic(optional = false)
	@Column(nullable = false)
	private String password;

	@ManyToMany
	@Valid
	private List<Coupon> coupons;

	public Customer() {
		coupons = new ArrayList<>();
	}

	public Customer(String name, String password, String country, String city, String address) {
		this.name = name;
		this.password = password;
		this.coupons = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> set) {
		this.coupons = set;
	}

	public void addCoupon(Coupon coupon) {
		this.coupons.add(coupon);
	}

	@Override
	public String toString() {
		return "Customer: id=" + id + ", name=" + name + ", password=" + password + " coupons: ";
	}
	
	
}