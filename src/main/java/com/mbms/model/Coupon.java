package com.mbms.model;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String title;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private Date startDate;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private Date endDate;

	@Basic(optional = false)
	@Column(nullable = false)
	private int amount;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private CouponCaregory category;

	@Basic(optional = false)
	@Column(nullable = false)
	private String message;

	@Basic(optional = false)
	@Column(nullable = false)
	private double price;

	@Basic(optional = false)
	@Column(nullable = false)
	private String image;
	
	@ManyToOne
	@JsonIgnore
	@Valid
	private Company company;
	@ManyToMany(mappedBy = "coupons")
	@Valid
	private List<Customer> customers;
	
}