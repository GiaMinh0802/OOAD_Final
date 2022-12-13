package Service.Impl;

import java.util.List;

import DAO.IBookingDetailDAO;
import DAO.Impl.BookingDetailDAOImpl;
import Model.BookingDetailModel;
import Model.FlightModel;
import Service.IBookingDetailService;

public class BookingDetailServiceImpl implements IBookingDetailService {
	IBookingDetailDAO bkDAO = new BookingDetailDAOImpl();
	
	@Override
	public List<BookingDetailModel> getMyBooking(String idUS) {
		return bkDAO.getMyBooking(idUS);
	}

	@Override
	public void insertBookingDetail(String idBK, String idTF) {
		bkDAO.insertBookingDetail(idBK, idTF);

	}

	@Override
	public List<String> getIdAndDateBooking() {
		return bkDAO.getIdAndDateBooking();
	}

	@Override
	public void cancelbooking(String idBK) {
		bkDAO.cancelbooking(idBK);
	}

	@Override
	public void insertBooking(String idUS, int quantity, int total) {
		bkDAO.insertBooking(idUS, quantity, total);
		
	}

	@Override
	public List<FlightModel> getIDFlightAndIDTicketClass(String idBK) {
		return bkDAO.getIDFlightAndIDTicketClass(idBK);
	}

	@Override
	public void updatecanel(FlightModel fl) {
		bkDAO.updatecanel(fl);
		
	}

}
