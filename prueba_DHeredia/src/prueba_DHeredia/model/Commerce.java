package prueba_DHeredia.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Commerce {

	private HashMap<Integer, Cart> carts;
	private HashMap<Integer, Cart> productos;
	//a�adir hasMap de productos

	public Commerce() {		
		this.carts = new HashMap<Integer, Cart>();
	}

	public HashMap<Integer, Cart> getCarts() {		
		return carts;
	}

	public void setCarts(HashMap<Integer, Cart> carts) {
		this.carts = carts;
	}
	
	public void createCart() {		
		Cart cart = new Cart();	
		cart.setTotalAmount(0);
		cart.setTimeCreation(System.currentTimeMillis());

		this.carts.put(assignNextId(), cart);
	}
	
	private int assignNextId() {
		int num = 1;
		
		
		if(this.carts.size() == 0) {
			num = 1;
		}else {
			for(int i=0;i<this.carts.size();i++) {
				num++;
			}
		}
		
		return num;
	}

	public HashMap<Integer, Cart> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<Integer, Cart> productos) {
		this.productos = productos;
	}
	
	public void addProduct() {
		// TODO Auto-generated method stub		
	}
	
	public void verCarts() {				
		for (Map.Entry<Integer, Cart> set : this.carts.entrySet()) {
           System.out.println(set.getKey() + "  | \t" + set.getValue().getTotalAmount() + "\t | \t" + set.getValue().getTimeCreation());
		}
	}
	
	public void selectCartById(int selectCartId) {
		System.out.println(this.carts.get(selectCartId).getTimeCreation()+"\n"
				+this.carts.get(selectCartId).getTotalAmount()+"\nLista de productos:\n");
		
		System.out.println(this.carts.get(selectCartId).getProducts());
		//for (this.carts.get(selectCartId).getProducts() product : this.carts.get(selectCartId).getProducts()) {
			
		//}		
	}

	@Override
	public int hashCode() {
		return Objects.hash(carts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commerce other = (Commerce) obj;
		return Objects.equals(carts, other.carts);
	}

}
