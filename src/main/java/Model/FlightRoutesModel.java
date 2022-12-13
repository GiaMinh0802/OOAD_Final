package Model;

public class FlightRoutesModel {
	private String idFR;
	private String idAPtoGo;
	private String nameCitytoGo;
	private String idAPtoCome;
	private String nameCitytoCome;
	
	public FlightRoutesModel() {
		super();
	}

	public FlightRoutesModel(String idFR, String idAPtoGo, String nameCitytoGo, String idAPtoCome,
			String nameCitytoCome) {
		super();
		this.idFR = idFR;
		this.idAPtoGo = idAPtoGo;
		this.nameCitytoGo = nameCitytoGo;
		this.idAPtoCome = idAPtoCome;
		this.nameCitytoCome = nameCitytoCome;
	}
	
	public String getIdFR() {
		return idFR;
	}

	public void setIdFR(String idFR) {
		this.idFR = idFR;
	}

	public String getIdAPtoGo() {
		return idAPtoGo;
	}

	public void setIdAPtoGo(String idAPtoGo) {
		this.idAPtoGo = idAPtoGo;
	}

	public String getIdAPtoCome() {
		return idAPtoCome;
	}

	public void setIdAPtoCome(String idAPtoCome) {
		this.idAPtoCome = idAPtoCome;
	}
	
	public String getNameCitytoGo() {
		return nameCitytoGo;
	}

	public void setNameCitytoGo(String nameCitytoGo) {
		this.nameCitytoGo = nameCitytoGo;
	}

	public String getNameCitytoCome() {
		return nameCitytoCome;
	}

	public void setNameCitytoCome(String nameCitytoCome) {
		this.nameCitytoCome = nameCitytoCome;
	}
}
