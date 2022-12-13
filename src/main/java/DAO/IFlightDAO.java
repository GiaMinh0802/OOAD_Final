package DAO;

import java.util.List;

import Model.FlightModel;

public interface IFlightDAO {
	List<FlightModel> getFlight(String idAPtoGo, String idAPtoCome, String nameTC, int number, String timetoGo, String timetoCome);
	FlightModel getFlightDetail(String idFL, String nameTC);
	List<FlightModel> getAll();
	void insert(String idFR, String idAL, String timetogo, String timetocome);
	String getnewIDInsert();
	void delete(String idFL);
}
