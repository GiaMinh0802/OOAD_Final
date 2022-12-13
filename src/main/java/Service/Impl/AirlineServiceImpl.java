package Service.Impl;

import java.util.List;

import DAO.IAirlineDAO;
import DAO.Impl.AirlineDAOImpl;
import Model.AirlineModel;
import Service.IAirlineService;

public class AirlineServiceImpl implements IAirlineService {
	IAirlineDAO alDAO = new AirlineDAOImpl();
	
	@Override
	public List<AirlineModel> getAll() {
		return alDAO.getAll();
	}

	@Override
	public void insert(AirlineModel al) {
		alDAO.insert(al);
		
	}

	@Override
	public void delete(String idAL) {
		alDAO.delete(idAL);
	}

	@Override
	public void edit(AirlineModel al) {
		alDAO.edit(al);
	}

	@Override
	public void editNotImage(AirlineModel al) {
		alDAO.editNotImage(al);
	}

	@Override
	public String getIDNew() {
		return alDAO.getIDNew();
	}

}
