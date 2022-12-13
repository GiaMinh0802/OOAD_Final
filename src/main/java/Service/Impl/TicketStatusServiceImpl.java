package Service.Impl;

import java.util.List;

import DAO.ITicketStatusDAO;
import DAO.Impl.TicketStatusDAOImpl;
import Model.TicketStatusModel;
import Service.ITicketStatusService;

public class TicketStatusServiceImpl implements ITicketStatusService {
	ITicketStatusDAO tsDAO = new TicketStatusDAOImpl();
	
	@Override
	public List<TicketStatusModel> getbyIdFL(String idFL) {
		return tsDAO.getbyIdFL(idFL);
	}

	@Override
	public void insert(String idFL, String idTC, int seats) {
		tsDAO.insert(idFL, idTC, seats);
	}

	@Override
	public void delete(String idFL, String idTC) {
		tsDAO.delete(idFL, idTC);
	}

	@Override
	public void edit(String idFL, String idTC, int totalint, int emptyint) {
		tsDAO.edit(idFL, idTC, totalint, emptyint);
	}

}
