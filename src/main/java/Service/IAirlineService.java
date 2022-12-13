package Service;

import java.util.List;

import Model.AirlineModel;

public interface IAirlineService {
	List<AirlineModel> getAll();
	void insert(AirlineModel al);
	void delete(String idAL);
	void edit(AirlineModel al);
	void editNotImage(AirlineModel al);
	String getIDNew();
}
