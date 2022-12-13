package Model;

public class FlightModel {
	private String idFL;
	private String idFR;
	private String nameCitytoGo;
	private String nameCitytoCome;
	private String idAL;
	private String nameTC;
	private int price;
	private String timetoGo;
	private String timetoCome;
	private String timeFL;
	private String nameAL;
	private String logoAL;
	private String idAPtoGo;
	private String idAPtoCome;
	private int emptySeat;
	private String idTC;
	private int count;
	
	public FlightModel() {
		super();
	}
	
	public FlightModel(String idFL, String idTC, int count) {
		super();
		this.idFL = idFL;
		this.idTC = idTC;
		this.count = count;
	}

	public FlightModel(String idFL, String nameTC, int price, String timetoGo, String timetoCome, String timeFL,
			String nameAL, String logoAL, String idAPtoGo, String idAPtoCome, int emptySeat) {
		super();
		this.idFL = idFL;
		this.nameTC = nameTC;
		this.price = price;
		this.timetoGo = timetoGo;
		this.timetoCome = timetoCome;
		this.timeFL = timeFL;
		this.nameAL = nameAL;
		this.logoAL = logoAL;
		this.idAPtoGo = idAPtoGo;
		this.idAPtoCome = idAPtoCome;
		this.emptySeat = emptySeat;
	}
	

	public FlightModel(String idFL, String idFR, String nameCitytoGo, String nameCitytoCome, String idAL,
			String nameAL, String timetoGo, String timetoCome) {
		super();
		this.idFL = idFL;
		this.idFR = idFR;
		this.nameCitytoGo = nameCitytoGo;
		this.nameCitytoCome = nameCitytoCome;
		this.idAL = idAL;
		this.timetoGo = timetoGo;
		this.timetoCome = timetoCome;
		this.nameAL = nameAL;
	}

	public String getIdFL() {
		return idFL;
	}

	public void setIdFL(String idFL) {
		this.idFL = idFL;
	}

	public String getNameTC() {
		return nameTC;
	}

	public void setNameTC(String nameTC) {
		this.nameTC = nameTC;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTimetoGo() {
		return timetoGo;
	}

	public void setTimetoGo(String timetoGo) {
		this.timetoGo = timetoGo;
	}

	public String getTimetoCome() {
		return timetoCome;
	}

	public void setTimetoCome(String timetoCome) {
		this.timetoCome = timetoCome;
	}

	public String getTimeFL() {
		return timeFL;
	}

	public void setTimeFL(String timeFL) {
		this.timeFL = timeFL;
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

	public int getEmptySeat() {
		return emptySeat;
	}

	public void setEmptySeat(int emptySeat) {
		this.emptySeat = emptySeat;
	}
	public String getIdFR() {
		return idFR;
	}

	public void setIdFR(String idFR) {
		this.idFR = idFR;
	}

	public String getIdAL() {
		return idAL;
	}

	public void setIdAL(String idAL) {
		this.idAL = idAL;
	}
	
	public String getIdTC() {
		return idTC;
	}

	public void setIdTC(String idTC) {
		this.idTC = idTC;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
