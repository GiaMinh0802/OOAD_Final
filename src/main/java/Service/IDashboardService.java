package Service;

import java.util.List;
import java.util.Map;

public interface IDashboardService {
	List<Integer> getDashboard();
	Map<Integer, Integer> getTicketBooked();
	Map<Integer, Integer> getSaleMonth();
}
