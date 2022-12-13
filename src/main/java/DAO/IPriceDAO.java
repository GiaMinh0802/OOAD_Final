package DAO;

import java.util.List;

import Model.PriceModel;

public interface IPriceDAO {
	List<PriceModel> getall();
	List<PriceModel> getbyIdFRAndIdAL(String idFR, String idAL);
	void edit(String idFR, String idTC, String idAL, int price);
	void insert(String idFR, String idTC, String idAL);
	void delete(String idFR, String idTC, String idAL);
}
