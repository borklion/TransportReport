package ru.borklion.dao;

public class Ticket {
	private String serial;
	private String number;
	private int price;
		
	public Ticket(String serial, String number, int price) {
		super();
		this.serial = serial;
		this.number = number;
		this.price = price;
	}

	public String getSerial() {
		return serial;
	}

	public String getNumber() {
		return number;
	}

	public int getPrice() {
		return price;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
