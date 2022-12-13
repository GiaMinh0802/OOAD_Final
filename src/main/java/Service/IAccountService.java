package Service;

import Model.AccountModel;

public interface IAccountService {
	AccountModel login(String email, String password);
	void insert(AccountModel account);
	void changepassword(String password, String idUS);
	void lockuser(String idCus);
	void unlockuser(String idCus);
}
