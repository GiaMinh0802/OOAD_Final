package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IAirportDAO;
import Model.AirportModel;

public class AirportDAOImpl extends DBConnection implements IAirportDAO {

	@Override
	public List<AirportModel> getAll() {
		List<AirportModel> ap = new ArrayList<AirportModel>();
		String sql = "SELECT * FROM Airports";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap.add(new AirportModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}	
			return ap;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<AirportModel> getTop4() {
		List<AirportModel> ap = new ArrayList<AirportModel>();
		String sql = "SELECT TOP(4) * FROM dbo.Airports ORDER BY NEWID()";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap.add(new AirportModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}	
			return ap;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void delete(String idAP) {
		String sql = "DELETE dbo.Airports WHERE idAirport = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idAP);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editNotImage(AirportModel ap) {
		String sql = "UPDATE dbo.Airports SET nameAirport = ?, cityAirport = ? WHERE idAirport = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ap.getNameAP());
			ps.setString(2, ap.getCityAP());
			ps.setString(3, ap.getIdAP());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(AirportModel ap) {
		String sql = "UPDATE dbo.Airports SET nameAirport = ?, cityAirport = ?, imagePlace = ? WHERE idAirport = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ap.getNameAP());
			ps.setString(2, ap.getCityAP());
			ps.setString(3, ap.getImagePlace());
			ps.setString(4, ap.getIdAP());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(AirportModel ap) {
		String sql = "INSERT dbo.Airports (idAirport, nameAirport, cityAirport, imagePlace) VALUES (?, ?, ?, ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ap.getIdAP());
			ps.setString(2, ap.getNameAP());
			ps.setString(3, ap.getCityAP());
			ps.setString(4, ap.getImagePlace());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
