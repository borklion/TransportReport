package ru.borklion;

public class Ticket {
	private String serial;
	private Integer number;
	private Integer price;
	
	public Ticket(String serial, Integer number, Integer price) {
		super();
		this.serial = serial;
		this.number = number;
		this.price = price;
	}

	public String getSerial() {
		return serial;
	}

	public Integer getNumber() {
		return number;
	}

	public Integer getPrice() {
		return price;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
