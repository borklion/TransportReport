package ru.borklion;

public class Ticket {
	private String serial;
	private int number;
	private int price;
	
	public Ticket(String serial, int number, int price) {
		super();
		this.serial = serial;
		this.number = number;
		this.price = price;
	}

	public String getSerial() {
		return serial;
	}

	public int getNumber() {
		return number;
	}

	public int getPrice() {
		return price;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
