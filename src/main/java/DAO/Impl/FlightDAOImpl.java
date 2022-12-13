package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IFlightDAO;
import Model.FlightModel;

public class FlightDAOImpl extends DBConnection implements IFlightDAO{

	@Override
	public List<FlightModel> getFlight(String idAPtoGo, String idAPtoCome, String nameTC, int number, String timetoGo, String timetoCome) {
		List<FlightModel> listfl = new ArrayList<FlightModel>();
		
		String sql = "EXEC dbo.USP_GetFlight ?, ?, ?, ?, ?, ?";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idAPtoGo);
			ps.setString(2, idAPtoCome);
			ps.setString(3, nameTC);
			ps.setInt(4, number);
			ps.setString(5, timetoGo);
			ps.setString(6, timetoCome);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listfl.add(new FlightModel(rs.getString(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getInt(11)));
			}	
			return listfl;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public FlightModel getFlightDetail(String idFL, String nameTC) {
		String sql = "EXEC dbo.USP_GetFlightByidFLAndnameTC ?, ?";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idFL);
			ps.setString(2, nameTC);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new FlightModel(rs.getString(1), 
									rs.getString(2), 
									rs.getInt(3), 
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getString(10),
									rs.getInt(11));
			}	
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<FlightModel> getAll() {
		List<FlightModel> listfl = new ArrayList<FlightModel>();
		
		String sql = "SELECT * FROM dbo.UV_GetFlight";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listfl.add(new FlightModel(rs.getString(1),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8)));
			}	
			return listfl;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insert(String idFR, String idAL, String timetogo, String timetocome) {
		String sql = "INSERT dbo.Flights (idFlights, idFlightRoutes, idAirline, timeToGo, timeToCome) VALUES ((SELECT dbo.UF_CreateIdFlight()), ?, ?, ?, ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idFR);
			ps.setString(2, idAL);
			ps.setString(3, timetogo);
			ps.setString(4, timetocome);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String idFL) {
		String sql = "DELETE dbo.Flights WHERE idFlights = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idFL);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getnewIDInsert() {
		String sql = "SELECT TOP(1) idFlights FROM dbo.Flights ORDER BY idFlights DESC";
		
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
