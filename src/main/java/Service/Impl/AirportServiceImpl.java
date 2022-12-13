package Service.Impl;

import java.util.List;

import DAO.IAirportDAO;
import DAO.Impl.AirportDAOImpl;
import Model.AirportModel;
import Service.IAirportService;

public class AirportServiceImpl implements IAirportService {
	IAirportDAO apDAO = new AirportDAOImpl();
	
	@Override
	public List<AirportModel> getAll() {
		return apDAO.getAll();
	}
	@Override
	public List<AirportModel> getTop4() {
		return apDAO.getTop4();
	}
	@Override
	public void delete(String idAP) {
		apDAO.delete(idAP);
		
	}
	@Override
	public void editNotImage(AirportModel ap) {
		apDAO.editNotImage(ap);
	}
	@Override
	public void edit(AirportModel ap) {
		apDAO.edit(ap);
	}
	@Override
	public void insert(AirportModel ap) {
		apDAO.insert(ap);
	}

}
