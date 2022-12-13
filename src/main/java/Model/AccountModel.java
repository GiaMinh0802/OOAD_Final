package Model;

public class AccountModel {
	private String email;
	private String pass;
	private String idUS;
	private int status;
	private int type;
	
	public AccountModel() {
		super();
	}
	
	public AccountModel(String email, String pass, String idUS, int status, int type) {
		super();
		this.email = email;
		this.pass = pass;
		this.idUS = idUS;
		this.setStatus(status);
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getIdUS() {
		return idUS;
	}

	public void setIdUS(String idUS) {
		this.idUS = idUS;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}	
}
