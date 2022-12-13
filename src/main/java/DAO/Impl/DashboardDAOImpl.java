package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Connection.DBConnection;
import DAO.IDashboardDAO;

public class DashboardDAOImpl extends DBConnection implements IDashboardDAO {

	@Override
	public List<Integer> getDashboard() {
		List<Integer> list = new ArrayList<Integer>();
		
		String sql = "SELECT * FROM dbo.UF_GetDashboard()";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt(1)); 
				list.add(rs.getInt(2)); 
				list.add(rs.getInt(3)); 
				list.add(rs.getInt(4)); 
			}	
			return list;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public Map<Integer, Integer> getTicketBooked() {
		Map<Integer, Integer> list = new HashMap<Integer, Integer>();
		
		String sql = "SELECT statusBooking ,COUNT(*) FROM dbo.Bookings GROUP BY statusBooking ORDER BY statusBooking DESC";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.put(rs.getInt(1) ,rs.getInt(2)); 
			}	
			return list;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public Map<Integer, Integer> getSaleMonth() {
		Map<Integer, Integer> list = new HashMap<Integer, Integer>();
		
		String sql = "SELECT MONTH(dateBooking), SUM(totalPrice) FROM dbo.Bookings WHERE statusBooking = 0 OR statusBooking = 1 GROUP BY MONTH(dateBooking)";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.put(rs.getInt(1) ,rs.getInt(2)); 
			}	
			return list;
		} catch (Exception e) {
		}
		
		return null;
	}

}
