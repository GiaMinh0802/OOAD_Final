package Model;

public class AirportModel {
	private String idAP;
	private String nameAP;
	private String cityAP;
	private String imagePlace;
	
	public AirportModel() {
		super();
	}

	public AirportModel(String idAP, String nameAP, String cityAP, String imagePlace) {
		super();
		this.idAP = idAP;
		this.nameAP = nameAP;
		this.cityAP = cityAP;
		this.imagePlace = imagePlace;
	}
	
	public String getIdAP() {
		return idAP;
	}

	public void setIdAP(String idAP) {
		this.idAP = idAP;
	}

	public String getNameAP() {
		return nameAP;
	}

	public void setNameAP(String nameAP) {
		this.nameAP = nameAP;
	}

	public String getCityAP() {
		return cityAP;
	}

	public void setCityAP(String cityAP) {
		this.cityAP = cityAP;
	}
	
	public String getImagePlace() {
		return imagePlace;
	}

	public void setImagePlace(String imagePlace) {
		this.imagePlace = imagePlace;
	}
}
