package DAO;

import java.util.List;

import Model.AirportModel;

public interface IAirportDAO {
	List<AirportModel> getAll();
	List<AirportModel> getTop4();
	void delete(String idAP);
	void editNotImage(AirportModel ap);
	void edit(AirportModel ap);
	void insert(AirportModel ap);
}
