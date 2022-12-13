package Service.Impl;

import java.util.List;

import DAO.IFlightRoutesDAO;
import DAO.Impl.FlightRoutesDAOImpl;
import Model.FlightRoutesModel;
import Service.IFlightRoutesService;

public class FlightRoutesServiceImpl implements IFlightRoutesService{
	IFlightRoutesDAO frDAO = new FlightRoutesDAOImpl();
	
	@Override
	public List<FlightRoutesModel> getall() {
		return frDAO.getall();
	}

	@Override
	public void insert(String idAPtoGo, String idAPtoCome) {
		frDAO.insert(idAPtoGo, idAPtoCome);
	}

	@Override
	public void delete(String idFR) {
		frDAO.delete(idFR);
		
	}

	@Override
	public String getnewIDInsert() {
		return frDAO.getnewIDInsert();
	}

}
