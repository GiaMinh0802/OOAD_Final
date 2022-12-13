package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ITicketClassDAO;
import Model.TicketClassModel;

public class TicketClassDAOImpl extends DBConnection implements ITicketClassDAO {

	@Override
	public List<TicketClassModel> getAll() {
		List<TicketClassModel> tk = new ArrayList<TicketClassModel>();
		String sql = "SELECT * FROM TicketClasses";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk.add(new TicketClassModel(rs.getString(1), rs.getString(2)));
			}	
			return tk;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void delete(String idTC) {
		String sql = "DELETE dbo.TicketClasses WHERE idTicketClass = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idTC);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(String nameTC) {
		String sql = "INSERT dbo.TicketClasses (idTicketClass, nameTicketClass) VALUES ((SELECT dbo.UF_CreateIdTicketClass()), ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nameTC);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(String idTC, String nameTC) {
		String sql = "UPDATE dbo.TicketClasses SET nameTicketClass = ? WHERE idTicketClass = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nameTC);
			ps.setString(2, idTC);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getIDNew() {
		String sql = "SELECT TOP(1) idTicketClass FROM dbo.TicketClasses ORDER BY idTicketClass DESC";
		
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
	
}
