package Controller.Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AccountModel;
import Model.FlightModel;
import Model.UserModel;
import Service.IBookingDetailService;
import Service.IUserService;
import Service.Impl.BookingDetailServiceImpl;
import Service.Impl.UserServiceImpl;
import Util.Function;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/booking", "/seller/booking"})
public class FlightBookingController extends HttpServlet{
	IUserService usService = new UserServiceImpl();
	IBookingDetailService bdService = new BookingDetailServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		@SuppressWarnings("unchecked")
		List<String> infoflight = (List<String>)session.getAttribute("infoflight");
		
		@SuppressWarnings("unchecked")
		List<String> infobooking = (List<String>)session.getAttribute("infobooking");
		
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		FlightModel go = (FlightModel) session.getAttribute("go");
		FlightModel back = (FlightModel) session.getAttribute("back");

		int total = (go.getPrice()+back.getPrice())*Integer.parseInt(infoflight.get(1));
		int quantity = 0;
		if (infobooking.size() == 2) {
			quantity = Integer.parseInt(infoflight.get(1));
		} else {
			quantity = Integer.parseInt(infoflight.get(1))*2;
		}
		
		for (int i = 1; i <= Integer.parseInt(infoflight.get(1)); i++) {
			String fullname = req.getParameter("fullname".concat(Integer.toString(i)));
			String phone = req.getParameter("phone".concat(Integer.toString(i)));
			UserModel us = new UserModel(null, fullname, phone, null, 1, null);
			if (infobooking.size() == 2) {
				usService.insertforBooking(us, infobooking.get(0), infobooking.get(1));
			} else {
				usService.insertforBooking(us, infobooking.get(0), infobooking.get(1));
				usService.insertforBooking(us, infobooking.get(2), infobooking.get(3));
			}
		}
		
		List<String> listIDTF = new ArrayList<String>();
		
		if (infobooking.size() == 2) {
			listIDTF = usService.getnewInsertforBooking(Integer.parseInt(infoflight.get(1)));
		} else {
			listIDTF = usService.getnewInsertforBooking(Integer.parseInt(infoflight.get(1))*2);
		}
		
		bdService.insertBooking(account.getIdUS(), quantity, total);
		
		List<String> infobk = bdService.getIdAndDateBooking();
		
		for (String idTF : listIDTF) {
			bdService.insertBookingDetail(infobk.get(0), idTF);
		}
		
		infobk.set(1, Function.convertDateForJSP(infobk.get(1)));
		
		infobk.add(Integer.toString(total));
		
		req.setAttribute("infobk", infobk);
		req.getRequestDispatcher("/views/web/flight-booking.jsp").forward(req, resp);
	}
	
}
