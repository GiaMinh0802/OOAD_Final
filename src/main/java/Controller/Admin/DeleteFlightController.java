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

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/delete-flight"})
public class DeleteFlightController extends HttpServlet {
	IFlightService flService = new FlightServiceImpl();
	ITicketClassService tcService = new TicketClassServiceImpl();
	ITicketStatusService tsService = new TicketStatusServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idFL = req.getParameter("idFL");
		List<TicketClassModel> listtc = tcService.getAll();
		
		for (TicketClassModel tc : listtc) {
			tsService.delete(idFL, tc.getIdTC());
		}
		
		flService.delete(idFL);
		
		resp.sendRedirect("flights");
	}

}
