package Model;

public class AirlineModel {
	private String idAL;
	private String nameAL;
	private String logoAL;
	
	public AirlineModel(String idAL, String nameAL, String logoAL) {
		super();
		this.idAL = idAL;
		this.nameAL = nameAL;
		this.logoAL = logoAL;
	}
	
	public AirlineModel() {
		super();
	}
	
	public String getIdAL() {
		return idAL;
	}
	public void setIdAL(String idAL) {
		this.idAL = idAL;
	}
	public String getNameAL() {
		return nameAL;
	}
	public void setNameAL(String nameAL) {
		this.nameAL = nameAL;
	}
	public String getLogoAL() {
		return logoAL;
	}
	public void setLogoAL(String logoAL) {
		this.logoAL = logoAL;
	}

}
