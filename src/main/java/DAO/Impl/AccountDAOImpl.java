package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnection;
import DAO.IAccountDAO;
import Model.AccountModel;

public class AccountDAOImpl extends DBConnection implements IAccountDAO {

	@Override
	public AccountModel login(String email, String password) {
		String sql = "SELECT * FROM Accounts WHERE emailAcc = ? AND passAcc = ?";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new AccountModel(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4),
						rs.getInt(5));
			}	
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insert(AccountModel account) {
		String sql = "INSERT dbo.Accounts (emailAcc, passAcc, idUser, statusAcc, typeAcc) VALUES (?, ?, ?, ?, 0)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getEmail());
			ps.setString(2, account.getPass());
			ps.setString(3, account.getIdUS());
			ps.setInt(4, account.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changepassword(String password, String idUS) {
		String sql = "UPDATE dbo.Accounts SET passAcc = ? WHERE idUser = ?";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, idUS);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void lockuser(String idCus) {
		String sql = "UPDATE dbo.Accounts SET statusAcc = -1 WHERE idUser = ?";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idCus);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void unlockuser(String idCus) {
		String sql = "UPDATE dbo.Accounts SET statusAcc = 1 WHERE idUser = ?";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idCus);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
