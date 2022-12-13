package Controller.Web;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AirportModel;
import Model.TicketClassModel;
import Service.IAirportService;
import Service.ITicketClassService;
import Service.Impl.AirportServiceImpl;
import Service.Impl.TicketClassServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home", "/seller/home"})
public class HomeController extends HttpServlet {
	ITicketClassService tcService = new TicketClassServiceImpl();
	IAirportService apService = new AirportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		session.removeAttribute("infoflight");
		session.removeAttribute("infobooking");
		session.removeAttribute("fl");
		session.removeAttribute("go");
		session.removeAttribute("back");
		
		List<TicketClassModel> gettc = tcService.getAll();
		List<AirportModel> getap = apService.getAll();
		List<AirportModel> aptop4 = apService.getTop4();
		
		req.setAttribute("listtc", gettc);
		req.setAttribute("listap", getap);
		req.setAttribute("aptop4", aptop4);
		req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
	}
}
