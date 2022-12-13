package Model;

public class TicketStatusModel {
	private String idFL;
	private String idTC;
	private String nameTC;
	private int totalseats;
	private int emptyseats;
	
	public TicketStatusModel(String idFL, String idTC, String nameTC, int totalseats, int emptyseats) {
		super();
		this.idFL = idFL;
		this.idTC = idTC;
		this.nameTC = nameTC;
		this.totalseats = totalseats;
		this.emptyseats = emptyseats;
	}
	
	public TicketStatusModel() {
		super();
	}
	
	public String getIdFL() {
		return idFL;
	}
	public void setIdFL(String idFL) {
		this.idFL = idFL;
	}
	public String getIdTC() {
		return idTC;
	}
	public void setIdTC(String idTC) {
		this.idTC = idTC;
	}
	public String getNameTC() {
		return nameTC;
	}
	public void setNameTC(String nameTC) {
		this.nameTC = nameTC;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	public int getEmptyseats() {
		return emptyseats;
	}
	public void setEmptyseats(int emptyseats) {
		this.emptyseats = emptyseats;
	}

}
