package DAO;

import java.util.List;

import Model.TicketStatusModel;

public interface ITicketStatusDAO {
	List<TicketStatusModel> getbyIdFL(String idFL);
	void insert(String idFL, String idTC, int seats);
	void delete(String idFL, String idTC);
	void edit(String idFL, String idTC, int totalint, int emptyint);
}
