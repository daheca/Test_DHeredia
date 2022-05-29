package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Product> products;
	private double totalAmount;
	private long timeCreation;

	public Cart() {
		this.products = new ArrayList<Product>();
	}

	public Cart(int totalAmount, long timeCreation) {
		this.products = new ArrayList<Product>();
		this.totalAmount = totalAmount;
		this.timeCreation = timeCreation;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getTimeCreation() {
		return timeCreation;
	}

	public void setTimeCreation(long timeCreation) {
		this.timeCreation = timeCreation;
	}

	public void addProduct(Product product) {
		products.add(product);
		this.totalAmount += product.getAmount();
	}
}
