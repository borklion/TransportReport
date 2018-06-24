package ru.borklion.model;

public class Ticket extends AbstractModel{
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
		firePropertyChange("serial",this.serial,serial);
		this.serial = serial;
	}

	public void setNumber(String number) {
		firePropertyChange("number",this.number,number);
		this.number = number;
	}

	public void setPrice(int price) {
		firePropertyChange("price",this.price,price);
		this.price = price;
	}
	
	@Override
	public String toString() {
		return serial +" №"+ number +" "+ price + " руб.";
	}
}
