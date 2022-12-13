package Service;

import java.util.List;

import Model.UserAndAccountModel;
import Model.UserModel;

public interface IUserService {
	UserModel getbyID(String idUS);
	void insert(UserModel user);
	void edit(UserModel user);
	String getnewInsert();
	void insertforBooking(UserModel user, String idFL, String nameTC);
	List<String> getnewInsertforBooking(int amount);
	List<UserAndAccountModel> getforAdmin();
	int checkUserexist(String name, String phone);
	String getIDExist(String name, String phone);
}
