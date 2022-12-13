package Model;

public class UserModel {
	private String idUS;
	private String nameUS;
	private String phoneUS;
	private String birthdayUS;
	private int sexUS;
	private String addressUS;
	
	public UserModel() {
		super();
	}
	
	public UserModel(String idUS, String nameUS, String phoneUS, String birthdayUS, int sexUS, String addressUS) {
		super();
		this.idUS = idUS;
		this.nameUS = nameUS;
		this.phoneUS = phoneUS;
		this.birthdayUS = birthdayUS;
		this.sexUS = sexUS;
		this.addressUS = addressUS;
	}
	public String getIdUS() {
		return idUS;
	}
	public void setIdUS(String idUS) {
		this.idUS = idUS;
	}
	public String getNameUS() {
		return nameUS;
	}
	public void setNameUS(String nameUS) {
		this.nameUS = nameUS;
	}
	public String getPhoneUS() {
		return phoneUS;
	}
	public void setPhoneUS(String phoneUS) {
		this.phoneUS = phoneUS;
	}
	public String getBirthdayUS() {
		return birthdayUS;
	}
	public void setBirthdayUS(String birthdayUS) {
		this.birthdayUS = birthdayUS;
	}
	public int getSexUS() {
		return sexUS;
	}
	public void setSexUS(int sexUS) {
		this.sexUS = sexUS;
	}
	public String getAddressUS() {
		return addressUS;
	}
	public void setAddressUS(String addressUS) {
		this.addressUS = addressUS;
	}
	
}
