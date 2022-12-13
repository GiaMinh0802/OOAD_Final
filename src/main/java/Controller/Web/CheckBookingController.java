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

import Model.FlightModel;
import Service.IFlightService;
import Service.Impl.FlightServiceImpl;
import Util.Function;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/check"})
public class CheckBookingController extends HttpServlet {
	IFlightService flService = new FlightServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String idFL = req.getParameter("flID");
		String nameTC = req.getParameter("tcName");
		HttpSession session = req.getSession();

		@SuppressWarnings("unchecked")
		List<String> infoflight = (List<String>)session.getAttribute("infoflight");
		
		if (infoflight.get(6).equals("yes")) {
			if (infoflight.get(7).equals("")) {
				infoflight.set(7, "2nd");
				List<String> infobooking = new ArrayList<String>();
				infobooking.add(idFL);
				infobooking.add(nameTC);
				
				List<FlightModel> listfl = flService.getFlight(infoflight.get(3).substring(0, 3), infoflight.get(2).substring(0, 3), infoflight.get(0), Integer.parseInt(infoflight.get(1)), Function.convertDateForSQL(infoflight.get(5))+" 00:00:00", Function.convertDateForSQL(infoflight.get(5))+" 23:59:59");
				
				session.setAttribute("infobooking", infobooking);
				session.setAttribute("fl", listfl);
				
				resp.sendRedirect("flight-list");
			} else {
				@SuppressWarnings("unchecked")
				List<String> infobooking = (List<String>)session.getAttribute("infobooking");
				infobooking.add(idFL);
				infobooking.add(nameTC);
				session.setAttribute("infobooking", infobooking);
				resp.sendRedirect("flight-detail");
			}
		} else {
			List<String> infobooking = new ArrayList<String>();
			infobooking.add(idFL);
			infobooking.add(nameTC);
			session.setAttribute("infobooking", infobooking);
			resp.sendRedirect("flight-detail");
		}
		
	}

}
