package Controller.Seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BookingDetailModel;
import Model.UserModel;
import Service.IBookingDetailService;
import Service.Impl.BookingDetailServiceImpl;
import Util.Function;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/seller/mybooking"})
public class MyBookingController extends HttpServlet {
	IBookingDetailService bkService = new BookingDetailServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object account = session.getAttribute("account");

		if (account != null) {
			UserModel user =  (UserModel) session.getAttribute("user");
			List<BookingDetailModel> mybk = bkService.getMyBooking(user.getIdUS());
			
			for (BookingDetailModel bk : mybk) {
				String date = Function.convertDateForJSP(bk.getDateBK());
				bk.setDateBK(date);
				date = Function.convertDateTimeForJSP(bk.getTimetoGo());
				bk.setTimetoGo(date);
			}
			
			List<BookingDetailModel> upcoming = new ArrayList<BookingDetailModel>();
			List<BookingDetailModel> canceled = new ArrayList<BookingDetailModel>();
			List<BookingDetailModel> completed = new ArrayList<BookingDetailModel>();
			for (BookingDetailModel bk : mybk) {
				if (bk.getStatus() == 1) {
					completed.add(bk);
				} else if (bk.getStatus() == 0) {
					upcoming.add(bk);
				} else {
					canceled.add(bk);
				}
			}
			req.setAttribute("upcoming", upcoming);
			req.setAttribute("canceled", canceled);
			req.setAttribute("completed", completed);
			req.getRequestDispatcher("/views/user/my-booking.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("sign-in");
		}
	}

}
