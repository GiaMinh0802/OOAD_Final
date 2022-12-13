package Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.FlightRoutesModel;
import Model.TicketClassModel;
import Service.IAirlineService;
import Service.IFlightRoutesService;
import Service.IPriceService;
import Service.ITicketClassService;
import Service.Impl.AirlineServiceImpl;
import Service.Impl.FlightRoutesServiceImpl;
import Service.Impl.PriceServiceImpl;
import Service.Impl.TicketClassServiceImpl;
import Util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/delete-airline"})
public class DeleteAirlineController extends HttpServlet {
	IAirlineService alService = new AirlineServiceImpl();
	IFlightRoutesService frService = new FlightRoutesServiceImpl();
	ITicketClassService tcService = new TicketClassServiceImpl();
	IPriceService priceService = new PriceServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idAL = req.getParameter("idAL");
		String image = req.getParameter("image");
		
		List<FlightRoutesModel> listfr = frService.getall();
		List<TicketClassModel> listtc = tcService.getAll();
		
		for (FlightRoutesModel fr : listfr) {
			for (TicketClassModel tc : listtc) {
				priceService.delete(fr.getIdFR(), tc.getIdTC(), idAL);
			}
		}
		
		alService.delete(idAL);
		
		try {
			File file = new File(Constant.DIR + "logoairlines".concat("\\") + image);
			file.delete();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("airlines");
	}

}
