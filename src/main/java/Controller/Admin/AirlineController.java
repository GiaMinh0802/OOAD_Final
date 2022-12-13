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
import Service.IAirlineService;
import Service.Impl.AirlineServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/airlines"})
public class AirlineController extends HttpServlet {
	IAirlineService alService = new AirlineServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		if (account != null) {
			if (account.getType() == 1) {
				List<AirlineModel> listal = alService.getAll();
				
				req.setAttribute("listal", listal);
				req.getRequestDispatcher("/views/admin/airline.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/sign-in");
		}	
	}
	
}
