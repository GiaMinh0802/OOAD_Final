package Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AccountModel;
import Model.FlightModel;
import Service.IFlightService;
import Service.Impl.FlightServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/flight-detail", "/flihgt-detail"})
public class FlightDetailController extends HttpServlet {
	IFlightService flService = new FlightServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		@SuppressWarnings("unchecked")
		List<String> infobooking = (List<String>)session.getAttribute("infobooking");
		
		@SuppressWarnings("unchecked")
		List<String> infoflight = (List<String>)session.getAttribute("infoflight");
		
		FlightModel go = new FlightModel();
		FlightModel back = new FlightModel();
		
		if (infobooking.size() == 4) {
			go = flService.getFlightDetail(infobooking.get(0), infobooking.get(1));
			back = flService.getFlightDetail(infobooking.get(2), infobooking.get(3));
		} else {
			go = flService.getFlightDetail(infobooking.get(0), infobooking.get(1));
		}
		
		session.setAttribute("go", go);
		if (back != null) {
			session.setAttribute("back", back);
		}
		session.setAttribute("infobooking", infobooking);
		session.setAttribute("infoflight", infoflight);
		if (account != null) {
			req.getRequestDispatcher("/views/web/flight-detail.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("sign-in");
		}
		
	}
	
}
