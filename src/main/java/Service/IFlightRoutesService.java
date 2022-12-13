package Service;

import java.util.List;

import Model.FlightRoutesModel;

public interface IFlightRoutesService {
	List<FlightRoutesModel> getall();
	void insert(String idAPtoGo, String idAPtoCome);
	void delete(String idFR);
	String getnewIDInsert();
}
