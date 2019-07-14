package com.mbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.mbms.exceptions.CouponSystemException;
import com.mbms.model.Company;
import com.mbms.model.Coupon;
import com.mbms.model.CouponCaregory;
import com.mbms.model.Customer;
import com.mbms.model.Utils;
import com.mbms.service.AdminServiceImpl;
import com.mbms.service.CompanyServiceImpl;
import com.mbms.service.CustomerServiceImpl;


@SpringBootApplication
@ComponentScan({ "com.mbms" })
public class Main {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
		
		AdminServiceImpl adminservice = applicationContext.getBean(AdminServiceImpl.class);
		CompanyServiceImpl companyservice = applicationContext.getBean(CompanyServiceImpl.class);
		CustomerServiceImpl customerservice = applicationContext.getBean(CustomerServiceImpl.class);
		
		
		System.out.println("**************** AdminService");
		
		System.out.println("**************** Creation company");
		Company company1 = new Company(0, "Fedrik", "z1z1", "Fedrik@Fedrik.com", null);
		Company company2 = new Company(0, "Fedrik", "z1z1", "Fedrik@Fedrik.com", null);
		Company company6 = new Company(258963, "Mars", "m1m1", "mars@mars.com", null);		
		Company company3 = new Company(1234567, "Coca Cola", "1234", "cocacola@gmail.com", null);
		Company company4 = new Company(2345678, "Google", "4444", "google@gmail.com", null);
		Company company5 = new Company(5, "Apple", "m123", "apple@gmail.com", null);
		
		try {
			adminservice.insertCompany(company1);
			adminservice.removeCompany(1);
			adminservice.insertCompany(company2);
			adminservice.insertCompany(company3);
			adminservice.insertCompany(company4);
			adminservice.insertCompany(company5);
			adminservice.insertCompany(company6);
			adminservice.updateCompany(company5);
			System.out.println("******************** get company by id");
			adminservice.getCompanyById(6);
		
		} catch (CouponSystemException e) {
			
			e.printStackTrace();
		}
		System.out.println("******************** get company all company");
		adminservice.getAllComapnies();
		

		
		System.out.println("**************** Creation customer");
	
		 Customer customer1= new Customer(1, "Johann Sebastian Bach", "kfkf99", null);
		 Customer customer2= new Customer( 2,"Wolfgang Amadeus Mozart", "kfkf99", null);
		 Customer customer3 = new Customer(3,"Ludwig van Beethoven","m777kkj", null);
		 Customer customer4 = new Customer(4,"Johannes Brahms", "b888k", null);
		 Customer customer5 = new Customer(5,"Franz Schubert", "l44kk4",null);
		
		try {
			adminservice.insertCustomer(customer1);
			adminservice.removeCustomer(1);
			adminservice.insertCustomer(customer2);
			adminservice.insertCustomer(customer3);
			adminservice.insertCustomer(customer4);
			adminservice.insertCustomer(customer5);
			adminservice.insertCustomer(customer1);
			
			adminservice.updateCustomer(customer2);
			
			System.out.println("******************** get customer by id");
			adminservice.getCustomerById(3);
			
		}catch (CouponSystemException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("******************** get all customer");
		System.out.println(adminservice.getAllCustomer());
		


		 Coupon coupon11 = new Coupon(11,"Fedrik 50% less", Utils.getCurrentDate(), Utils.getExpiredDate(), 5, CouponCaregory.RESTURANS, "Fedrik coupon", 20.5, "image.png",company1, null);
		 Coupon coupon12 = new Coupon(12,"Fedrik for free", Utils.getCurrentDate(), Utils.getExpiredDate(), 6, CouponCaregory.RESTURANS, "Fedrik coupon", 10.3, "image.png",company1, null);
		 Coupon coupon13 = new Coupon(13,"Fedrik discount", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 7,CouponCaregory.RESTURANS, "Fedrik coupon", 50.2, "image.png",company1, null);
		 Coupon coupon14 = new Coupon(14,"Fedrik deal", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 8, CouponCaregory.RESTURANS, "Fedrik coupon", 10.4, "image.png",company1, null);
		 Coupon coupon15 = new Coupon(15,"Fedrik meal", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 9, CouponCaregory.RESTURANS, "Fedrik coupon", 5.5, "image.png",company1, null);
		
		 Coupon coupon21 = new Coupon(21,"Mars 50% less", Utils.getCurrentDate(), Utils.getExpiredDate(), 10, CouponCaregory.FOOD, "Mars coupon", 20.5, "image.png", company2, null);
		 Coupon coupon22 = new Coupon(22,"Mars for free", Utils.getCurrentDate(), Utils.getExpiredDate(), 12, CouponCaregory.FOOD, "Mars coupon", 3.2, "image.png", company2, null);
		 Coupon coupon23 = new Coupon(23, "Mars discount", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 5, CouponCaregory.FOOD, "Mars coupon", 4.4, "image.png",  company2, null);
		 Coupon coupon24 = new Coupon(24,"Mars deal", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 4, CouponCaregory.FOOD, "Mars coupon", 5.5, "image.png" ,company2, null);
		 Coupon coupon25 = new Coupon(25,"Mars- new choclate deal", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 3,CouponCaregory.FOOD, "Mars coupon", 20, "image.png", company2, null);
		
		Coupon coupon31 = new Coupon(31,"Coca Cola- cola 50% less", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 10,CouponCaregory.HAELTH, "Coca Cola coupon", 20.5, "image.png", company3, null);
		 Coupon coupon32 = new Coupon(32,"Coca Cola for free", Utils.getCurrentDate(), Utils.getExpiredDate(), 12, CouponCaregory.HAELTH, "Coca Cola coupon", 3.2, "image.png", company3, null);
		 Coupon coupon33 = new Coupon(33,"Coca Cola discount", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 5, CouponCaregory.HAELTH, "Coca Cola coupon", 4.4, "image.png", company3, null);
		 Coupon coupon34 = new Coupon(34,"Coca Cola deal", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 4, CouponCaregory.HAELTH, "Coca Cola coupon", 5.5, "image.png", company3, null);
		 Coupon coupon35 = new Coupon(35,"new cola deal", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 3, CouponCaregory.HAELTH, "Coca Cola coupon", 20, "image.png", company3, null);
		
		 Coupon coupon41 = new Coupon(41,"Google around the world", Utils.getCurrentDate(), Utils.getExpiredDate(), 11,CouponCaregory.TRAVELING, "Google coupon", 1.90, "image.png", company4, null);
		 Coupon coupon42 = new Coupon(42,"Google race", Utils.getCurrentDate(), Utils.getExpiredDate(), 20, CouponCaregory.TRAVELING, "Google coupon", 10.90, "image.png",company4, null);
		 Coupon coupon43 = new Coupon(43,"Google Bicycle", Utils.getCurrentDate(), Utils.getExpiredDate(), 81, CouponCaregory.TRAVELING, "Google coupon", 11.90, "image.png",company4, null);
		 Coupon coupon44 = new Coupon(44,"Google city run", Utils.getCurrentDate(), Utils.getExpiredDate(), 71, CouponCaregory.TRAVELING, "Google coupon", 4.90, "image.png",company4, null);
		 Coupon coupon45 = new Coupon(45,"Google traveling", Utils.getCurrentDate(), Utils.getExpiredDate(), 41, CouponCaregory.TRAVELING, "Google coupon", 8, "image.png",company4, null);
		
		 Coupon coupon51 = new Coupon(51,"Apple store coupon", Utils.getCurrentDate(), Utils.getExpiredDate(), 11, CouponCaregory.ELECTRICITY, "Apple coupon", 1.90, "image.png",company5, null);
		 Coupon coupon52 = new Coupon(52,"Iphone 50% less", Utils.getCurrentDate(), Utils.getExpiredDate(), 20, CouponCaregory.ELECTRICITY, "Apple coupon", 10.90, "image.png",company5, null);
		 Coupon coupon53 = new Coupon(53,"Apple deal", Utils.getCurrentDate(), Utils.getExpiredDate(), 81, CouponCaregory.ELECTRICITY, "Apple coupon", 11.90, "image.png",company5, null);
		 Coupon coupon54 = new Coupon(54,"Apple store discount", Utils.getCurrentDate(), Utils.getExpiredDate(), 71,CouponCaregory.ELECTRICITY, "Apple coupon", 4.90, "image.png",company5, null);
		 Coupon coupon55 = new Coupon(55,"headphones 2+1", Utils.getCurrentDate(), Utils.getExpiredDate(), 41, CouponCaregory.ELECTRICITY, "Apple coupon", 8, "image.png",company5, null);
			
			
		try{
			// (**) login as company Apple 
			System.out.println("CompanyService = login as Apple");
			companyservice.performLogin(company5.getName(), company5.getPassword() );		

			
			System.out.println("(11) Insert copons");
			companyservice.insertCoupon(coupon51, 5);
			companyservice.insertCoupon(coupon52, 5);
			companyservice.insertCoupon(coupon53, 5);
			companyservice.insertCoupon(coupon54, 5);
			companyservice.insertCoupon(coupon55, 5);
			
			System.out.println("(14) Get copons");
			System.out.println(companyservice. getCompanyCoupons(5));
			
			
					}catch (Exception e){
						System.out.println(e.getMessage());
					}
			
				
			try{
	//(19) login as costumer:
	System.out.println("CompanyService = login as Apple");
	customerservice.performLogin(customer3.getName(), customer3.getPassword() );		


	System.out.println("--------------------------------------------------------------------- ");
	System.out.println("(11) Buy copons");
	customerservice.purchaseCoupon(3,1);
	customerservice.purchaseCoupon(3,2);
	customerservice.purchaseCoupon(3,3);
	customerservice.purchaseCoupon(3,4);
	customerservice.purchaseCoupon(3,5);
	

	System.out.println("--------------------------------------------------------------------- ");

	System.out.println("(11) get All Purchased Coupons By Customer");
	System.out.println(customerservice.getAllCustomerCoupons(3));

	System.out.println("--------------------------------------------------------------------- ");

	System.out.println("(11) get All Purchased Coupons By type");
	System.out.println(customerservice.getCouponByCategory(3, CouponCaregory.TRAVELING));
	System.out.println("(11) get All Purchased Coupons By price");
	System.out.println(customerservice.getCouponLowerThanPrice(3,5.5));

}catch (Exception e){
	System.out.println(e.getMessage());
}



applicationContext.close();
}}
