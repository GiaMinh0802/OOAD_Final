package Service;

import java.util.List;

import Model.PriceModel;

public interface IPriceService {
	List<PriceModel> getall();
	void edit(String idFR, String idTC, String idAL, int price);
	List<PriceModel> getbyIdFRAndIdAL(String idFR, String idAL);
	void insert(String idFR, String idTC, String idAL);
	void delete(String idFR, String idTC, String idAL);
}
