package com.entity;

public class BookOrders {
	
	private int id;
	private String orderId;
	private String userName;
	private String email;
	private String phno;
	private String fullAddress;
	private String bookName;
	private double price;
	private String author;
	private String paymentType;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	@Override
	public String toString() {
		return "BookOrders [id=" + id + ", orderId=" + orderId + ", userName=" + userName + ", email=" + email
				+ ", phno=" + phno + ", fullAddress=" + fullAddress + ", bookName=" + bookName + ", price=" + price
				+ ", author=" + author + ", paymentType=" + paymentType + "]";
	}
}
