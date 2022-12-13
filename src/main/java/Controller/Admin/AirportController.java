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
import Service.IAirportService;
import Service.Impl.AirportServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/airports"})
public class AirportController extends HttpServlet {
	IAirportService apService = new AirportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		if (account != null) {
			if (account.getType() == 1) {
				List<AirportModel> listap = apService.getAll();
				
				req.setAttribute("listap", listap);
				req.getRequestDispatcher("/views/admin/airport.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/sign-in");
		}		
	}

}
