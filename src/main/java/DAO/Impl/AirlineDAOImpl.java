package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IAirlineDAO;
import Model.AirlineModel;

public class AirlineDAOImpl extends DBConnection implements IAirlineDAO {

	@Override
	public List<AirlineModel> getAll() {
		List<AirlineModel> al = new ArrayList<AirlineModel>();
		String sql = "SELECT * FROM Airlines";
		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				al.add(new AirlineModel(rs.getString(1), rs.getString(2), rs.getString(3)));
			}	
			return al;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public void insert(AirlineModel al) {
		String sql = "INSERT dbo.Airlines (idAirline, nameAirline, logoAirline) VALUES ((SELECT dbo.UF_CreateIdAirline()), ?, ?)";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, al.getNameAL());
			ps.setString(2, al.getLogoAL());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String idAL) {
		String sql = "DELETE dbo.Airlines WHERE idAirline = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, idAL);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(AirlineModel al) {
		String sql = "UPDATE dbo.Airlines SET nameAirline = ?, logoAirline = ? WHERE idAirline = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, al.getNameAL());
			ps.setString(2, al.getLogoAL());
			ps.setString(3, al.getIdAL());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editNotImage(AirlineModel al) {
		String sql = "UPDATE dbo.Airlines SET nameAirline = ? WHERE idAirline = ?";

		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, al.getNameAL());
			ps.setString(2, al.getIdAL());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getIDNew() {
		String sql = "SELECT TOP(1) idAirline FROM dbo.Airlines ORDER BY idAirline DESC";
		
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
