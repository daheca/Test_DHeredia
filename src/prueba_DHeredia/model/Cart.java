package prueba_DHeredia.model;

import java.util.List;

public class Cart {

	private List<Product> products;
	private int totalAmount;
	private long timeCreation;
	
	public Cart() {
	}

	public Cart(List<Product> products, int totalAmount, long timeCreation) {
		this.products = products;
		this.totalAmount = totalAmount;
		this.timeCreation = timeCreation;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getTotalAmount() {
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

	private void calcTotalAmount(List<Product> products) {		
		for(int i=0;i<products.size();i++) {
			this.totalAmount += products.get(i).getAmount();
		}
	}
	
}
