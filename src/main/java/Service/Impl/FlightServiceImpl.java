package Service.Impl;

import java.util.List;

import DAO.IFlightDAO;
import DAO.Impl.FlightDAOImpl;
import Model.FlightModel;
import Service.IFlightService;

public class FlightServiceImpl implements IFlightService {
	IFlightDAO flDAO = new FlightDAOImpl();
	
	@Override
	public List<FlightModel> getFlight(String idAPtoGo, String idAPtoCome, String nameTC, int number, String timetoGo, String timetoCome) {
		return flDAO.getFlight(idAPtoGo, idAPtoCome, nameTC, number, timetoGo, timetoCome);
	}

	@Override
	public FlightModel getFlightDetail(String idFL, String nameTC) {
		return flDAO.getFlightDetail(idFL, nameTC);
	}

	@Override
	public List<FlightModel> getAll() {
		return flDAO.getAll();
	}

	@Override
	public void insert(String idFR, String idAL, String timetogo, String timetocome) {
		flDAO.insert(idFR, idAL, timetogo, timetocome);
		
	}

	@Override
	public void delete(String idFL) {
		flDAO.delete(idFL);
	}

	@Override
	public String getnewIDInsert() {
		return flDAO.getnewIDInsert();
	}
}
