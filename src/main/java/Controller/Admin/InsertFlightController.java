package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TicketClassModel;
import Service.IFlightService;
import Service.ITicketClassService;
import Service.ITicketStatusService;
import Service.Impl.FlightServiceImpl;
import Service.Impl.TicketClassServiceImpl;
import Service.Impl.TicketStatusServiceImpl;
import Util.Function;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/add-flight"})
public class InsertFlightController extends HttpServlet {
	IFlightService flService = new FlightServiceImpl();
	ITicketClassService tcService = new TicketClassServiceImpl();
	ITicketStatusService tsService = new TicketStatusServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idFR = req.getParameter("idFR");
		String idAL = req.getParameter("idAL");
		String timetogo = Function.convertDateTimeForSQL(req.getParameter("timetogo"));
		String timetocome = Function.convertDateTimeForSQL(req.getParameter("timetocome"));
		
		flService.insert(idFR, idAL, timetogo, timetocome);
		
		String idFL = flService.getnewIDInsert();
		
		List<TicketClassModel> listtc = tcService.getAll();
		
		for (TicketClassModel tc : listtc) {
			tsService.insert(idFL, tc.getIdTC(), 0);
		}
		
		resp.sendRedirect("flights");
	}

}
