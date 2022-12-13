package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IFlightRoutesDAO;
import Model.FlightRoutesModel;

public class FlightRoutesDAOImpl extends DBConnection implements IFlightRoutesDAO {

	@Override
	public List<FlightRoutesModel> getall() {
		List<FlightRoutesModel> fr = new ArrayList<FlightRoutesModel>();
		String sql = "SELECT idFlightRoutes, idAirportToGo, AirportToGo.cityAirport, idAirportToCome, AirportToCome.cityAirport FROM dbo.FlightRoutes\r\n"
				+ "INNER JOIN dbo.Airports AS AirportToGo \r\n"
				+ "ON AirportToGo.idAirport = FlightRoutes.idAirportToGo\r\n"
				+ "INNER JOIN dbo.Airports AS AirportToCome\r\n"
				+ "ON AirportToCome.idAirport = FlightRoutes.idAirportToCome\r\n"
				+ "ORDER BY AirportToGo.cityAirport";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fr.add(new FlightRoutesModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}	
			return fr;
		} catch (Exception e) {
		}
		return null;	}

	@Override
	public void insert(String idAPtoGo, String idAPtoCome) {
		String sql = "INSERT dbo.FlightRoutes (idFlightRoutes, idAirportToGo, idAirportToCome) VALUES ((SELECT dbo.UF_CreateIdFlightRoutes()), ?, ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idAPtoGo);
			ps.setString(2, idAPtoCome);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String idFR) {
		String sql = "DELETE dbo.FlightRoutes WHERE idFlightRoutes = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idFR);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getnewIDInsert() {
		String sql = "SELECT TOP(1) idFlightRoutes FROM dbo.FlightRoutes ORDER BY idFlightRoutes DESC";
		
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
