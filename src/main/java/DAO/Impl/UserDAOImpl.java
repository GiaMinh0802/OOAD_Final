package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IUserDAO;
import Model.UserAndAccountModel;
import Model.UserModel;

public class UserDAOImpl extends DBConnection implements IUserDAO {

	@Override
	public UserModel getbyID(String idUS) {
		String sql = "SELECT * FROM dbo.Users WHERE idUser = ?";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idUS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new UserModel(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6));
			}	
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT dbo.Users (idUser, nameUser, phoneUser, birthdayUser, sexUser, addressUser) VALUES ((SELECT dbo.UF_CreateIdUser()), ?, ?, (SELECT GETDATE()), ?, ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getNameUS());
			ps.setString(2, user.getPhoneUS());
			ps.setInt(3, user.getSexUS());
			ps.setString(4, user.getAddressUS());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void edit(UserModel user) {
		String sql = "UPDATE dbo.Users SET nameUser = ?, phoneUser = ?, birthdayUser = ?, sexUser = ?, addressUser = ? WHERE idUser = ?";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getNameUS());
			ps.setString(2, user.getPhoneUS());
			ps.setString(3, user.getBirthdayUS());
			ps.setInt(4, user.getSexUS());
			ps.setString(5, user.getAddressUS());
			ps.setString(6, user.getIdUS());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getnewInsert() {
		String sql = "SELECT TOP(1) idUser FROM dbo.Users ORDER BY idUser DESC";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}	
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insertforBooking(UserModel user, String idFL, String nameTC) {
		String sql = "EXEC dbo.USP_InsertUserAndTicketFlight ?, ?, ?, ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getNameUS());
			ps.setString(2, user.getPhoneUS());
			ps.setString(3, idFL);
			ps.setString(4, nameTC);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getnewInsertforBooking(int amount) {
		List<String> list = new ArrayList<String>();
		
		String sql = "SELECT TOP(?) idTicket FROM dbo.TicketFlights ORDER BY idTicket DESC";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, amount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}	
			return list;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<UserAndAccountModel> getforAdmin() {
		List<UserAndAccountModel> list = new ArrayList<UserAndAccountModel>();
		
		String sql = "SELECT Users.idUser, nameUser, phoneUser, birthdayUser, sexUser, addressUser, emailAcc, passAcc, statusAcc  FROM dbo.Users FULL JOIN dbo.Accounts ON Accounts.idUser = Users.idUser WHERE typeAcc = 0 OR typeAcc IS NULL";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserAndAccountModel(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getInt(9)));
			}	
			return list;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public int checkUserexist(String name, String phone) {
		String sql = "SELECT COUNT(*) FROM dbo.Users WHERE nameUser = ? AND phoneUser = ?";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}	
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public String getIDExist(String name, String phone) {
		String sql = "SELECT idUser  FROM dbo.Users WHERE nameUser = ? AND phoneUser = ?";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}	
		} catch (Exception e) {
		}
		return null;
	}



}
