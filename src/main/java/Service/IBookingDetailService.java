package Service;

import java.util.List;

import Model.BookingDetailModel;
import Model.FlightModel;

public interface IBookingDetailService {
	List<BookingDetailModel> getMyBooking(String idUS);
	void insertBooking(String idUS, int quantity, int total);
	List<String> getIdAndDateBooking();
	void insertBookingDetail(String idBK, String idTF);
	void cancelbooking(String idBK);
	List<FlightModel> getIDFlightAndIDTicketClass(String idBK);
	void updatecanel(FlightModel fl);
}
