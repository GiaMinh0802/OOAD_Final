package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IPriceDAO;
import Model.PriceModel;

public class PriceDAOImpl extends DBConnection implements IPriceDAO {

	@Override
	public List<PriceModel> getall() {
		List<PriceModel> price = new ArrayList<PriceModel>();
		String sql = "SELECT * FROM dbo.UV_GetPrice ORDER BY idFlightRoutes, idAirline, idTicketClass";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				price.add(new PriceModel(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getInt(8)));
			}	
			return price;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void edit(String idFR, String idTC, String idAL, int price) {
		String sql = "UPDATE dbo.Prices SET unitPrice = ? WHERE idFlightRoutes = ? AND idTicketClass = ? AND idAirline = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, price);
			ps.setString(2, idFR);
			ps.setString(3, idTC);
			ps.setString(4, idAL);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<PriceModel> getbyIdFRAndIdAL(String idFR, String idAL) {
		List<PriceModel> price = new ArrayList<PriceModel>();
		String sql = "SELECT * FROM dbo.UV_GetPrice WHERE idFlightRoutes = ? AND idAirline = ? ORDER BY idFlightRoutes, idAirline, idTicketClass";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idFR);
			ps.setString(2, idAL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				price.add(new PriceModel(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getInt(8)));
			}	
			return price;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insert(String idFR, String idTC, String idAL) {
		String sql = "INSERT dbo.Prices (idFlightRoutes, idTicketClass, idAirline) VALUES (?, ?, ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idFR);
			ps.setString(2, idTC);
			ps.setString(3, idAL);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String idFR, String idTC, String idAL) {
		String sql = "DELETE dbo.Prices WHERE idFlightRoutes = ? AND idTicketClass = ? AND idAirline = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idFR);
			ps.setString(2, idTC);
			ps.setString(3, idAL);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
