package DAO;

import java.util.List;

import Model.TicketClassModel;

public interface ITicketClassDAO {
	List<TicketClassModel> getAll();
	void delete(String idTC);
	void insert(String nameTC);
	void edit(String idTC, String nameTC);
	String getIDNew();
}
