package web.prog.shared;

import java.util.ArrayList;

public class POSTransaction {

	Customer customer;
	ArrayList<InventoryItem> invList = new ArrayList<InventoryItem>();
	double total;
	boolean isPaid;
}
