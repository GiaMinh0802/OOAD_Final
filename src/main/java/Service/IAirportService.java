package Service;

import java.util.List;

import Model.AirportModel;

public interface IAirportService {
	List<AirportModel> getAll();
	List<AirportModel> getTop4();
	void delete(String idAP);
	void editNotImage(AirportModel ap);
	void edit(AirportModel ap);
	void insert(AirportModel airport);
}
