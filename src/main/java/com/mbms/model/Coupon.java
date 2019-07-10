package com.mbms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

import example1.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private Date startDate;
	
	private Date endDate;

	private int amount;
	private CouponCaregory category;

	private String message;
	@Positive(message = "The coupon price must be positive")
	private double price;
	@URL(message = "The image must be a URL")
	private String image;
	@ManyToOne
	@JsonIgnore
	@Valid
	private Company company;
	@ManyToMany(mappedBy = "coupons")
	@Valid
	private List<Customer> customers;
	
}