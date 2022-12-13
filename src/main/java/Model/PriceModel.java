package Model;

public class PriceModel {
	private String idFR;
	private String nameCitytoGo;
	private String nameCitytoCome;
	private String idTC;
	private String nameTC;
	private String idAL;
	private String nameAL;
	private int price;
	
	public PriceModel() {
		super();
	}
	
	public PriceModel(String idFR, String nameCitytoGo, String nameCitytoCome,
			String idTC, String nameTC, String idAL, String nameAL, int price) {
		super();
		this.idFR = idFR;
		this.nameCitytoGo = nameCitytoGo;
		this.nameCitytoCome = nameCitytoCome;
		this.idTC = idTC;
		this.nameTC = nameTC;
		this.idAL = idAL;
		this.nameAL = nameAL;
		this.price = price;
	}

	public PriceModel(String idFR, String idTC, String idAL, int price) {
		super();
		this.idFR = idFR;
		this.idTC = idTC;
		this.idAL = idAL;
		this.price = price;
	}

	public String getIdFR() {
		return idFR;
	}
	public void setIdFR(String idFR) {
		this.idFR = idFR;
	}
	public String getIdTC() {
		return idTC;
	}
	public void setIdTC(String idTC) {
		this.idTC = idTC;
	}
	public String getIdAL() {
		return idAL;
	}
	public void setIdAL(String idAL) {
		this.idAL = idAL;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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

	public String getNameTC() {
		return nameTC;
	}

	public void setNameTC(String nameTC) {
		this.nameTC = nameTC;
	}

	public String getNameAL() {
		return nameAL;
	}

	public void setNameAL(String nameAL) {
		this.nameAL = nameAL;
	}
	
}
