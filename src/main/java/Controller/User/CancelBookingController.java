package Controller.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.FlightModel;
import Service.IBookingDetailService;
import Service.Impl.BookingDetailServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/cancelbooking"})
public class CancelBookingController extends HttpServlet {
	IBookingDetailService bdService = new BookingDetailServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idBK = req.getParameter("idBK");
		bdService.cancelbooking(idBK);
		
		List<FlightModel> list = bdService.getIDFlightAndIDTicketClass(idBK);
		
		for (FlightModel fl : list) {
			bdService.updatecanel(fl);
		}
		
		resp.sendRedirect("mybooking");
	}
	
}
