package DAO;

import Model.AccountModel;

public interface IAccountDAO {
	AccountModel login(String email, String password);
	void insert(AccountModel account);
	void changepassword(String password, String idUS);
	void lockuser(String idCus);
	void unlockuser(String idCus);
}
