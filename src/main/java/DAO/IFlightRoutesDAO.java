package DAO;

import java.util.List;

import Model.FlightRoutesModel;

public interface IFlightRoutesDAO {
	List<FlightRoutesModel> getall();
	void insert(String idAPtoGo, String idAPtoCome);
	void delete(String idFR);
	String getnewIDInsert();
}
