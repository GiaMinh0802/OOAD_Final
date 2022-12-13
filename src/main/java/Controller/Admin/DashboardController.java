package Controller.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AccountModel;
import Model.AirportModel;
import Service.IAirportService;
import Service.IDashboardService;
import Service.Impl.AirportServiceImpl;
import Service.Impl.DashboardServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin"})
public class DashboardController extends HttpServlet {
	IDashboardService dbService = new DashboardServiceImpl();
	IAirportService apService = new AirportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		if (account != null) {
			if (account.getType() == 1) {
				List<Integer> listdb = dbService.getDashboard();
				Map<Integer, Integer> listbk = dbService.getTicketBooked();
				Map<Integer, Integer> listsale = dbService.getSaleMonth();
				List<AirportModel> listap = apService.getTop4();
				Set<Integer> set1 = listsale.keySet();
				Set<Integer> set2 = listbk.keySet();
				
				int jan = 0;
				int feb = 0;
				int mar = 0;
				int apr = 0;
				int may = 0;
				int jun = 0;
				int jul = 0;
				int aug = 0;
				int sep = 0;
				int oct = 0;
				int nov = 0;
				int dec = 0;
				int booked = 0;
				int cancel = 0;
				
				for (Integer key : set1) {
					if (key == 1) {
						jan = listsale.get(key);
					} else if (key == 2) {
						feb = listsale.get(key);
					} else if (key == 3) {
						mar = listsale.get(key);
					} else if (key == 4) {
						apr = listsale.get(key);
					} else if (key == 5) {
						may = listsale.get(key);
					} else if (key == 6) {
						jun = listsale.get(key);
					} else if (key == 7) {
						jul = listsale.get(key);
					} else if (key == 8) {
						aug = listsale.get(key);
					} else if (key == 9) {
						sep = listsale.get(key);
					} else if (key == 10) {
						oct = listsale.get(key);
					} else if (key == 11) {
						nov = listsale.get(key);
					} else if (key == 12) {
						dec = listsale.get(key);
					}
				}
				
				for (Integer key : set2) {
					if (key == 1 || key == 0) {
						booked = booked + listbk.get(key);
					} else {
						cancel = cancel + listbk.get(key);
					}
				}
				
				req.setAttribute("jan", jan);
				req.setAttribute("feb", feb);
				req.setAttribute("mar", mar);
				req.setAttribute("apr", apr);
				req.setAttribute("may", may);
				req.setAttribute("jun", jun);
				req.setAttribute("jul", jul);
				req.setAttribute("aug", aug);
				req.setAttribute("sep", sep);
				req.setAttribute("oct", oct);
				req.setAttribute("nov", nov);
				req.setAttribute("dec", dec);
				req.setAttribute("booked", booked);
				req.setAttribute("cancel", cancel);
				req.setAttribute("listap", listap);
				req.setAttribute("listdb", listdb);
				req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("sign-in");
			}
		} else {
			resp.sendRedirect("sign-in");
		}
	}

}
