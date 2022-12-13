package Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AirlineModel;
import Model.FlightModel;
import Model.FlightRoutesModel;
import Service.IAirlineService;
import Service.IFlightRoutesService;
import Service.IFlightService;
import Service.IPriceService;
import Service.ITicketClassService;
import Service.ITicketStatusService;
import Service.Impl.AirlineServiceImpl;
import Service.Impl.FlightRoutesServiceImpl;
import Service.Impl.FlightServiceImpl;
import Service.Impl.PriceServiceImpl;
import Service.Impl.TicketClassServiceImpl;
import Service.Impl.TicketStatusServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/add-ticketclass"})
public class InsertTicketClassController extends HttpServlet {
	IAirlineService alService = new AirlineServiceImpl();
	IFlightRoutesService frService = new FlightRoutesServiceImpl();
	ITicketClassService tcService = new TicketClassServiceImpl();
	IFlightService flService = new FlightServiceImpl();
	IPriceService priceService = new PriceServiceImpl();
	ITicketStatusService tsService = new TicketStatusServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nameTC = req.getParameter("nameTC");
		
		tcService.insert(nameTC);
		
		String idTC = tcService.getIDNew();
		
		List<FlightRoutesModel> listfr = frService.getall();
		List<AirlineModel> listal = alService.getAll();
		List<FlightModel> listfl = flService.getAll();
		
		for (FlightRoutesModel fr : listfr) {
			for (AirlineModel al : listal) {
				priceService.insert(fr.getIdFR(), idTC, al.getIdAL());
			}
		}
		
		for (FlightModel fl : listfl) {
			tsService.insert(fl.getIdFL(), idTC, 0);
		}
		
		resp.sendRedirect("ticketclasses");
	}

}
