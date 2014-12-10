package web.prog.shared;

import java.util.ArrayList;

public class POSTransaction {

	Customer customer;
	ArrayList<InventoryItem> invList = new ArrayList<InventoryItem>();
	double total;
	boolean isPaid;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public ArrayList<InventoryItem> getInvList() {
		return invList;
	}
	public void setInvList(ArrayList<InventoryItem> invList) {
		this.invList = invList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	@Override
	public String toString() {
		return "POSTransaction [customer=" + customer + ", invList=" + invList
				+ ", total=" + total + ", isPaid=" + isPaid + "]";
	}
	public POSTransaction(Customer customer, ArrayList<InventoryItem> invList,
			double total, boolean isPaid) {
		super();
		this.customer = customer;
		this.invList = invList;
		this.total = total;
		this.isPaid = isPaid;
	}
}
