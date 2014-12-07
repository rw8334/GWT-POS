package web.prog.shared;

public class InventoryItem {
	
	String description;
	String sku;
	String pictureLink;
	String price;
	String inventoryNum;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInventoryNum() {
		return inventoryNum;
	}

	public void setInventoryNum(String inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	@Override
	public String toString() {
		return "InventoryItem [description=" + description + ", sku=" + sku
				+ ", pictureLink=" + pictureLink + ", price=" + price
				+ ", inventoryNum=" + inventoryNum + "]";
	}

	public InventoryItem(String description, String sku, String pictureLink,
			String price, String inventoryNum) {
		super();
		this.description = description;
		this.sku = sku;
		this.pictureLink = pictureLink;
		this.price = price;
		this.inventoryNum = inventoryNum;
	}
}
