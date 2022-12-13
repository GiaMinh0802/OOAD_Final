package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IBookingDetailDAO;
import Model.BookingDetailModel;
import Model.FlightModel;

public class BookingDetailDAOImpl extends DBConnection implements IBookingDetailDAO {

	@Override
	public List<BookingDetailModel> getMyBooking(String idUS) {
		List<BookingDetailModel> bk = new ArrayList<BookingDetailModel>();
		String sql = "EXEC dbo.USP_GetMyBookingByIdUser ?";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idUS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bk.add(new BookingDetailModel(rs.getString(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8)));
			}	
			return bk;
		} catch (Exception e) {
		}
		return null;	}

	@Override
	public void insertBooking(String idUS, int quantity, int total) {
		String sql = "INSERT dbo.Bookings(idBooking, idUser, dateBooking, quantity, totalPrice, statusBooking) VALUES ((SELECT dbo.UF_CreateIdBooking()),  ?, GETDATE(), ?, ?, 0)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idUS);
			ps.setInt(2, quantity);
			ps.setInt(3, total);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getIdAndDateBooking() {
		List<String> list = new ArrayList<String>();
		String sql = "SELECT TOP(1) idBooking, dateBooking FROM dbo.Bookings ORDER BY idBooking DESC";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 list.add(rs.getString(1));
				 list.add(rs.getString(2));
			}	
			return list;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insertBookingDetail(String idBK, String idTF) {
		String sql = "INSERT dbo.BookingDetail(idBooking, idTicket) VALUES(?, ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idBK);
			ps.setString(2, idTF);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancelbooking(String idBK) {
		String sql = "UPDATE dbo.Bookings SET statusBooking = -1 WHERE idBooking = ?";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idBK);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FlightModel> getIDFlightAndIDTicketClass(String idBK) {
		List<FlightModel> list = new ArrayList<FlightModel>();
		String sql = "SELECT idFlights, idTicketClass, COUNT(*) FROM dbo.Bookings \r\n"
				+ "	INNER JOIN dbo.BookingDetail ON BookingDetail.idBooking = Bookings.idBooking \r\n"
				+ "	INNER JOIN dbo.TicketFlights ON TicketFlights.idTicket = BookingDetail.idTicket\r\n"
				+ "	WHERE Bookings.idBooking = ?"
				+ "	GROUP BY idFlights, idTicketClass";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idBK);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new FlightModel(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}	
			return list;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void updatecanel(FlightModel fl) {
		String sql = "UPDATE dbo.TicketStatus SET emptySeats = emptySeats + ? WHERE idFlights = ? AND idTicketClass = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, fl.getCount());
			ps.setString(2, fl.getIdFL());
			ps.setString(3, fl.getIdTC());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
