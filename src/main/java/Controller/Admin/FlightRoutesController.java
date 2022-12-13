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
import Model.AirportModel;
import Model.FlightRoutesModel;
import Service.IAirportService;
import Service.IFlightRoutesService;
import Service.Impl.AirportServiceImpl;
import Service.Impl.FlightRoutesServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/flightroutes"})
public class FlightRoutesController extends HttpServlet{
	IFlightRoutesService frService = new FlightRoutesServiceImpl();
	IAirportService apService = new AirportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		if (account != null) {
			if (account.getType() == 1) {
				List<FlightRoutesModel> listfr = frService.getall();
				
				List<AirportModel> getap = apService.getAll();
				
				req.setAttribute("listap", getap);
				req.setAttribute("listfr", listfr);
				req.getRequestDispatcher("/views/admin/flightroutes.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/sign-in");
		}	
		
	}

}
