package com.kbstar.dto;

public class ItemDTO {
	private int itmNo;
	private String name;
	private double price;
	private int qt;
	
	public ItemDTO() {
	}

	public ItemDTO(int itmNo, String name, int price, int qt) {
		this.itmNo = itmNo;
		this.name = name;
		this.price = price;
		this.qt = qt;
	}

	public int getItmNo() {
		return itmNo;
	}

	public void setItmNo(int itmNo) {
		this.itmNo = itmNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQt() {
		return qt;
	}

	public void setQt(int qt) {
		this.qt = qt;
	}

	@Override
	public String toString() {
		return "ItemDTO [itmNo=" + itmNo + ", name=" + name + ", price=" + price + ", qt=" + qt + "]";
	}
	
	
}
