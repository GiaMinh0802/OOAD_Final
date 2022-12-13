package Service.Impl;

import java.util.List;

import DAO.IPriceDAO;
import DAO.Impl.PriceDAOImpl;
import Model.PriceModel;
import Service.IPriceService;

public class PriceServiceImpl implements IPriceService {
	IPriceDAO priceDAO = new PriceDAOImpl();
	
	@Override
	public List<PriceModel> getall() {
		return priceDAO.getall();
	}
	@Override
	public void edit(String idFR, String idTC, String idAL, int price) {
		priceDAO.edit(idFR, idTC, idAL, price);
	}
	@Override
	public List<PriceModel> getbyIdFRAndIdAL(String idFR, String idAL) {
		return priceDAO.getbyIdFRAndIdAL(idFR, idAL);
	}
	@Override
	public void insert(String idFR, String idTC, String idAL) {
		priceDAO.insert(idFR, idTC, idAL);
	}
	@Override
	public void delete(String idFR, String idTC, String idAL) {
		priceDAO.delete(idFR, idTC, idAL);
		
	}

}
