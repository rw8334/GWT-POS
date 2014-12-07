package web.prog.shared;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.ListDataProvider;

public class InventoryTable {

	public CellTable<InventoryItem> table = new CellTable<InventoryItem>();
	public ArrayList<InventoryItem> invList = new ArrayList<InventoryItem>();
	public ListDataProvider<InventoryItem> dataProvider = new ListDataProvider<InventoryItem>();
	
	public InventoryTable() {
		
		TextColumn<InventoryItem> descriptionColumn = new TextColumn<InventoryItem>() {

			@Override
			public String getValue(InventoryItem item) {
				return item.getDescription();
			}

		};

		TextColumn<InventoryItem> skuColumn = new TextColumn<InventoryItem>() {

			@Override
			public String getValue(InventoryItem item) {
				return item.getSku();
			}

		};
		
		TextColumn<InventoryItem> pictureLinkColumn = new TextColumn<InventoryItem>(){

			@Override
			public String getValue(InventoryItem item) {
				return item.getPictureLink();
			}
			
		};
		
		TextColumn<InventoryItem> priceColumn = new TextColumn<InventoryItem>(){

			@Override
			public String getValue(InventoryItem item) {
				return item.getPrice();
			}
			
		};
		
		TextColumn<InventoryItem> invNumColumn = new TextColumn<InventoryItem>(){

			@Override
			public String getValue(InventoryItem item) {
				return item.getInventoryNum();
			}
			
		};

		table.addColumn(descriptionColumn, "Description");
		table.addColumn(skuColumn, "SKU");
		table.addColumn(pictureLinkColumn, "Picture Link");
		table.addColumn(priceColumn, "Price");
		table.addColumn(invNumColumn, "Inventory");
		
		dataProvider.addDataDisplay(table);
	}
	
	public void tableDraw(){
		reinitialize();
		List<InventoryItem> list = dataProvider.getList();
		for (InventoryItem item : invList) {
			list.add(item);
		}
	}
	
	public void reinitialize(){
		
		dataProvider = new ListDataProvider<InventoryItem>();
		dataProvider.addDataDisplay(table);
	}
}
