package com.harshareddy.model;

public class Customer {

	 int cust_id;
	 String cust_first_name;
	 String cust_last_name;
	 String cust_email;
	 String cust_city;
	 String cust_country;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Customer(int cust_id, String cust_first_name, String cust_last_name, String cust_email, String cust_city,
			String cust_country) {
		super();
		this.cust_id = cust_id;
		this.cust_first_name = cust_first_name;
		this.cust_last_name = cust_last_name;
		this.cust_email = cust_email;
		this.cust_city = cust_city;
		this.cust_country = cust_country;
	}



	public Customer(String cust_first_name, String cust_last_name, String cust_email, String cust_city,
			String cust_country) {
		super();
		this.cust_first_name = cust_first_name;
		this.cust_last_name = cust_last_name;
		this.cust_email = cust_email;
		this.cust_city = cust_city;
		this.cust_country = cust_country;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_first_name() {
		return cust_first_name;
	}

	public void setCust_first_name(String cust_first_name) {
		this.cust_first_name = cust_first_name;
	}

	public String getCust_last_name() {
		return cust_last_name;
	}

	public void setCust_last_name(String cust_last_name) {
		this.cust_last_name = cust_last_name;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_city() {
		return cust_city;
	}

	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}

	public String getCust_country() {
		return cust_country;
	}

	public void setCust_country(String cust_country) {
		this.cust_country = cust_country;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_first_name=" + cust_first_name + ", cust_last_name="
				+ cust_last_name + ", cust_email=" + cust_email + ", cust_city=" + cust_city + ", cust_country="
				+ cust_country + "]";
	}

}
