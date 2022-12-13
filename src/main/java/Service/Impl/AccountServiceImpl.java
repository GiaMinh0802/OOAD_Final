package Service.Impl;

import DAO.IAccountDAO;
import DAO.Impl.AccountDAOImpl;
import Model.AccountModel;
import Service.IAccountService;

public class AccountServiceImpl implements IAccountService {
	IAccountDAO accDAO = new AccountDAOImpl();
	@Override
	public AccountModel login(String email, String password) {
		return accDAO.login(email, password);
	}
	@Override
	public void insert(AccountModel account) {
		accDAO.insert(account);
	}
	@Override
	public void changepassword(String password, String idUS) {
		accDAO.changepassword(password, idUS);
	}
	@Override
	public void lockuser(String idCus) {
		accDAO.lockuser(idCus);
		
	}
	@Override
	public void unlockuser(String idCus) {
		accDAO.unlockuser(idCus);
	}

}
