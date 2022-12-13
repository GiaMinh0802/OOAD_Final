package Model;

public class BookingDetailModel {
	private String placeGo;
	private String placeCome;
	private String idBK;
	private String nameTC;
	private String timetoGo;
	private String dateBK;
	private String nameBK;
	private int status;
	
	public BookingDetailModel() {
		super();
	}
	
	public BookingDetailModel(String placeGo, String placeCome, String idBK, String nameTC, String timetoGo,
			String dateBK, String nameBK, int status) {
		super();
		this.placeGo = placeGo;
		this.placeCome = placeCome;
		this.idBK = idBK;
		this.nameTC = nameTC;
		this.timetoGo = timetoGo;
		this.dateBK = dateBK;
		this.nameBK = nameBK;
		this.status = status;
	}
	
	public String getPlaceGo() {
		return placeGo;
	}
	public void setPlaceGo(String placeGo) {
		this.placeGo = placeGo;
	}
	public String getPlaceCome() {
		return placeCome;
	}
	public void setPlaceCome(String placeCome) {
		this.placeCome = placeCome;
	}
	public String getIdBK() {
		return idBK;
	}
	public void setIdBK(String idBK) {
		this.idBK = idBK;
	}
	public String getNameTC() {
		return nameTC;
	}
	public void setNameTC(String nameTC) {
		this.nameTC = nameTC;
	}
	public String getTimetoGo() {
		return timetoGo;
	}
	public void setTimetoGo(String timetoGo) {
		this.timetoGo = timetoGo;
	}
	public String getDateBK() {
		return dateBK;
	}
	public void setDateBK(String dateBK) {
		this.dateBK = dateBK;
	}
	public String getNameBK() {
		return nameBK;
	}
	public void setNameBK(String nameBK) {
		this.nameBK = nameBK;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
