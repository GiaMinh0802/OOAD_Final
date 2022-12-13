package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ITicketStatusDAO;
import Model.TicketStatusModel;

public class TicketStatusDAOImpl extends DBConnection implements ITicketStatusDAO {

	@Override
	public List<TicketStatusModel> getbyIdFL(String idFL) {
		List<TicketStatusModel> listts = new ArrayList<TicketStatusModel>();
		
		String sql = "SELECT * FROM dbo.UV_GetTicketStatus WHERE idFlights = ?";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idFL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listts.add(new TicketStatusModel(rs.getString(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4),
						rs.getInt(5)));
			}	
			return listts;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insert(String idFL, String idTC, int seats) {
		String sql = "INSERT dbo.TicketStatus (idFlights, idTicketClass, totalSeats, emptySeats) VALUES (?, ?, ?, ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idFL);
			ps.setString(2, idTC);
			ps.setInt(3, seats);
			ps.setInt(4, seats);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String idFL, String idTC) {
		String sql = "DELETE dbo.TicketStatus WHERE idFlights = ? AND idTicketClass = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idFL);
			ps.setString(2, idTC);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(String idFL, String idTC, int totalint, int emptyint) {
		String sql = "UPDATE dbo.TicketStatus SET totalSeats = ?, emptySeats = ? WHERE idFlights = ? AND idTicketClass = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, totalint);
			ps.setInt(2, emptyint);
			ps.setString(3, idFL);
			ps.setString(4, idTC);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
