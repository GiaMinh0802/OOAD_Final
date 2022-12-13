package Service.Impl;

import java.util.List;
import java.util.Map;

import DAO.IDashboardDAO;
import DAO.Impl.DashboardDAOImpl;
import Service.IDashboardService;

public class DashboardServiceImpl implements IDashboardService{
	IDashboardDAO dbDAO = new DashboardDAOImpl();
	@Override
	public List<Integer> getDashboard() {
		return dbDAO.getDashboard();
	}
	@Override
	public Map<Integer, Integer> getTicketBooked() {
		return dbDAO.getTicketBooked();
	}
	@Override
	public Map<Integer, Integer> getSaleMonth() {
		return dbDAO.getSaleMonth();
	}
	
}
