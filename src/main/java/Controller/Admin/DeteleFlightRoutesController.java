package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AirlineModel;
import Model.TicketClassModel;
import Service.IAirlineService;
import Service.IFlightRoutesService;
import Service.IPriceService;
import Service.ITicketClassService;
import Service.Impl.AirlineServiceImpl;
import Service.Impl.FlightRoutesServiceImpl;
import Service.Impl.PriceServiceImpl;
import Service.Impl.TicketClassServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/delete-flightroutes"})
public class DeteleFlightRoutesController extends HttpServlet {
	IFlightRoutesService frService = new FlightRoutesServiceImpl();
	ITicketClassService tcService = new TicketClassServiceImpl();
	IAirlineService alService = new AirlineServiceImpl();
	IPriceService priceService = new PriceServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idFR = req.getParameter("idFR");
		
		List<TicketClassModel> listtc = tcService.getAll();
		List<AirlineModel> listal = alService.getAll();
		
		for (AirlineModel al : listal) {
			for (TicketClassModel tc : listtc) {
				priceService.delete(idFR, tc.getIdTC(), al.getIdAL());
			}
		}
		
		frService.delete(idFR);
		
		resp.sendRedirect("flightroutes");
	}

}
