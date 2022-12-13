package Model;

public class TicketClassModel {
	private String idTC;
	private String nameTC;
	
	public TicketClassModel() {
		super();
	}
	
	public TicketClassModel(String idTC, String nameTC) {
		super();
		this.idTC = idTC;
		this.nameTC = nameTC;
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
}
