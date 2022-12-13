package DAO;

import java.util.List;
import java.util.Map;

public interface IDashboardDAO {
	List<Integer> getDashboard();
	Map<Integer, Integer> getTicketBooked();
	Map<Integer, Integer> getSaleMonth();
}
