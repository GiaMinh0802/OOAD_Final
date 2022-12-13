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
@WebServlet(urlPatterns = {"/findticket"})
public class FindTicketController extends HttpServlet {
	IFlightService flService = new FlightServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		
		String travelclass = req.getParameter("class");
		String number = req.getParameter("number");
		String from = null;
		String to = null;
		String dp = null;
		String from_oneway = req.getParameter("from_oneway");
		String to_oneway = req.getParameter("to_oneway");
		String dp_oneway = req.getParameter("departure_oneway");
		String from_round = req.getParameter("from_round");
		String to_round = req.getParameter("to_round");
		String dp_round = req.getParameter("departure_round");
		String rt_round = req.getParameter("return_round");
		
		String roundtrip = null;
		
		if (rt_round.equals("")) {
			roundtrip = "no";
			from = from_oneway;
			to = to_oneway;
			dp = dp_oneway;
		} else {
			roundtrip = "yes";
			from = from_round;
			to = to_round;
			dp = dp_round;
		}
		
		List<String> infoflight = new ArrayList<String>();
		infoflight.add(travelclass);
		infoflight.add(number);
		infoflight.add(from);
		infoflight.add(to);
		infoflight.add(dp);
		infoflight.add(rt_round);
		infoflight.add(roundtrip);
		infoflight.add("");

		List<FlightModel> listfl = flService.getFlight(from.substring(0, 3), to.substring(0, 3), travelclass, Integer.parseInt(number), Function.convertDateForSQL(dp)+" 00:00:00", Function.convertDateForSQL(dp)+" 23:59:59");
	
		session.setAttribute("infoflight", infoflight);
		session.setAttribute("fl", listfl);
		
		resp.sendRedirect("flight-list");
	}
}
