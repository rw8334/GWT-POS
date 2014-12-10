package web.prog.shared;

public class Customer {
	String customerFirstName;
	String customerLastName;
	int customerID;
	
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	@Override
	public String toString() {
		return "Customer [customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerID="
				+ customerID + "]";
	}
	
	public Customer(String customerFirstName, String customerLastName,
			int customerID) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerID = customerID;
	}
}
