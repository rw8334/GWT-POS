package web.prog.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.ListDataProvider;

public class TransactionTable {

	public CellTable<POSTransaction> table = new CellTable<POSTransaction>();
	public ArrayList<POSTransaction> transactionList = new ArrayList<POSTransaction>();
	public ListDataProvider<POSTransaction> dataProvider = new ListDataProvider<POSTransaction>();

	public TransactionTable() {
		TextColumn<POSTransaction> customerColumn = new TextColumn<POSTransaction>() {

			@Override
			public String getValue(POSTransaction transaction) {
				Customer customer = transaction.getCustomer();
				return customer.customerFirstName + " " + customer.customerLastName;
			}

		};

		TextColumn<POSTransaction> itemColumn = new TextColumn<POSTransaction>() {

			@Override
			public String getValue(POSTransaction transaction) {
				String result = "";
				for (InventoryItem item : transaction.getInvList()) {
					result = result + item.getDescription() + ", ";
				}
				return result;
			}

		};

		TextColumn<POSTransaction> totalColumn = new TextColumn<POSTransaction>() {

			@Override
			public String getValue(POSTransaction transaction) {
				return "" + transaction.getTotal();
			}

		};

		TextColumn<POSTransaction> paidColumn = new TextColumn<POSTransaction>() {

			@Override
			public String getValue(POSTransaction transaction) {
				if (transaction.isPaid) {
					return "PAID";
				} else if (!transaction.isPaid) {
					return "NOT PAID";
				}

				return "NULL";

			}

		};

		table.addColumn(customerColumn, "Customer Name");
		table.addColumn(itemColumn, "Items");
		table.addColumn(totalColumn, "Total");
		table.addColumn(paidColumn, "Paid");

		dataProvider.addDataDisplay(table);
	}

	public void tableDraw() {
		reinitialize();
		List<POSTransaction> list = dataProvider.getList();
		
		for(POSTransaction t : transactionList){
			list.add(t);
		}
	}

	public void reinitialize() {

		dataProvider = new ListDataProvider<POSTransaction>();
		dataProvider.addDataDisplay(table);
	}
}
