package Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AirportModel;
import Model.TicketClassModel;
import Service.IAirportService;
import Service.ITicketClassService;
import Service.Impl.AirportServiceImpl;
import Service.Impl.TicketClassServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/flight-list", "/seller/flight-list"})
public class FlightListController extends HttpServlet {
	ITicketClassService tcService = new TicketClassServiceImpl();
	IAirportService apService = new AirportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<TicketClassModel> gettc = tcService.getAll();
		List<AirportModel> getap = apService.getAll();
		
		req.setAttribute("listtc", gettc);
		req.setAttribute("listap", getap);
		
		req.getRequestDispatcher("/views/web/flight-list.jsp").forward(req, resp);
	}


}
