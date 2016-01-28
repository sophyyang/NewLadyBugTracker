package Tables;

public class ItemList {
	private 	int ID;
	private 	String description;
	private 	String iClass;
	private 	int iOrder;
	private 	int dropdownListID;
	private final int statusNo = 1;
	private final int roleNo = 2;
	private final int priorityNo = 3;
	
	public ItemList() {
		
	}
	
	public ItemList(int ID, String description) {
		this.ID = ID;
		this.description = description;
	}
	
	public ItemList(int ID, int iOrder) {
		this.ID = ID;
		this.iOrder = iOrder;
	}
	
	public ItemList(int ID, String description, int dropdownListID, int iOrder) {
		this.ID = ID;
		this.description = description;
		this.dropdownListID = dropdownListID;
		this.iOrder = iOrder;
	}

	public String[] getColumnNames() {
		String[] arrays = {"ID", "Class", "Description", "Order"} ;
		return arrays;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getiClass() {
		return iClass;
	}
	public void setiClass(String iClass) {
		this.iClass = iClass;
	}
	public int getiOrder() {
		return iOrder;
	}
	public void setiOrder(int iOrder) {
		this.iOrder = iOrder;
	}

	
	public int getDropdownListID() {
		return dropdownListID;
	}
	public void setDropdownListID(int dropdownListID) {
		this.dropdownListID = dropdownListID;
	}
	

	
	@Override
	public String toString() {
		return "ID=" + ID + ", description='" + description  + "', iOrder=" + iOrder
				+ ", dropdownListID='" + dropdownListID + "' LastModified = NOW() ";
	}

}
