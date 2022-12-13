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
import Model.TicketStatusModel;
import Service.ITicketStatusService;
import Service.Impl.TicketStatusServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/ticketstatus"})
public class TicketStatusController extends HttpServlet {
	ITicketStatusService tsService = new TicketStatusServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		if (account != null) {
			if (account.getType() == 1) {
				String idFL = req.getParameter("idFL");
				
				List<TicketStatusModel> listts =  tsService.getbyIdFL(idFL);
				
				req.setAttribute("listts", listts);
				req.getRequestDispatcher("/views/admin/ticketstatus.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/sign-in");
		}
	}

}
