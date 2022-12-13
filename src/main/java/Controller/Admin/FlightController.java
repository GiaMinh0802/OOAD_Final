package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AccountModel;
import Model.AirlineModel;
import Model.FlightModel;
import Model.FlightRoutesModel;
import Service.IAirlineService;
import Service.IFlightRoutesService;
import Service.IFlightService;
import Service.Impl.AirlineServiceImpl;
import Service.Impl.FlightRoutesServiceImpl;
import Service.Impl.FlightServiceImpl;
import Util.Function;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/flights"})
public class FlightController extends HttpServlet {
	IFlightService flService = new FlightServiceImpl();
	IFlightRoutesService frService = new FlightRoutesServiceImpl();
	IAirlineService alService = new AirlineServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		if (account != null) {
			if (account.getType() == 1) {
				List<FlightModel> listfl = flService.getAll();
				List<FlightRoutesModel> listfr = frService.getall();
				List<AirlineModel> listal = alService.getAll();
				
				
				for (FlightModel fl : listfl) {
					fl.setTimetoGo(Function.convertDateTimeForJSP(fl.getTimetoGo()));
					fl.setTimetoCome(Function.convertDateTimeForJSP(fl.getTimetoCome()));
				}
				
				req.setAttribute("listal", listal);
				req.setAttribute("listfr", listfr);
				req.setAttribute("listfl", listfl);
				req.getRequestDispatcher("/views/admin/flight.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/sign-in");
		}	
		
	
	}

}
