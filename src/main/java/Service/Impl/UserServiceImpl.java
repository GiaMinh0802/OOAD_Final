package Service.Impl;

import java.util.List;

import DAO.IUserDAO;
import DAO.Impl.UserDAOImpl;
import Model.UserAndAccountModel;
import Model.UserModel;
import Service.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDAO usDAO = new UserDAOImpl();
	
	@Override
	public UserModel getbyID(String idUS) {
		return usDAO.getbyID(idUS);
	}

	@Override
	public void insert(UserModel user) {
		usDAO.insert(user);
		
	}
	
	@Override
	public void edit(UserModel user) {
		usDAO.edit(user);
	}
	
	@Override
	public String getnewInsert() {
		return usDAO.getnewInsert();
	}

	@Override
	public void insertforBooking(UserModel user, String idFL, String nameTC) {
		usDAO.insertforBooking(user, idFL, nameTC);
	}

	@Override
	public List<String> getnewInsertforBooking(int amount) {
		return usDAO.getnewInsertforBooking(amount);
	}

	@Override
	public List<UserAndAccountModel> getforAdmin() {
		return usDAO.getforAdmin();
	}

	@Override
	public int checkUserexist(String name, String phone) {
		return usDAO.checkUserexist(name, phone);
	}

	@Override
	public String getIDExist(String name, String phone) {
		return usDAO.getIDExist(name, phone);
	}

	

}
