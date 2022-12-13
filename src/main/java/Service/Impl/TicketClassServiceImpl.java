package Service.Impl;

import java.util.List;

import DAO.ITicketClassDAO;
import DAO.Impl.TicketClassDAOImpl;
import Model.TicketClassModel;
import Service.ITicketClassService;

public class TicketClassServiceImpl implements ITicketClassService {
	ITicketClassDAO tkDAO = new TicketClassDAOImpl();
	@Override
	public List<TicketClassModel> getAll() {
		return tkDAO.getAll();
	}
	@Override
	public void delete(String idTC) {
		tkDAO.delete(idTC);
	}
	@Override
	public void insert(String nameTC) {
		tkDAO.insert(nameTC);
	}
	@Override
	public void edit(String idTC, String nameTC) {
		tkDAO.edit(idTC, nameTC);
	}
	@Override
	public String getIDNew() {
		return tkDAO.getIDNew();
	}
}
