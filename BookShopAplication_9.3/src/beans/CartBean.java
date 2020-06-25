package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartBean implements Serializable {
	private String[] selectedIds;
	private List<Integer> cart;
	public CartBean() {
		this.cart = new ArrayList<Integer>();
	}
	public String[] getSelectedIds() {
		return selectedIds;
	}
	public void setSelectedIds(String[] selectedIds) {
		this.selectedIds = selectedIds;
	}
	public List<Integer> getCart() {
		return cart;
	}
	public void setCart(List<Integer> cart) {
		this.cart = cart;
	}
	public String addToCart( ) {
		for (String selectedId : selectedIds) {
			this.cart.add(Integer.parseInt(selectedId));
		}
		return "Subject";
	}
}
