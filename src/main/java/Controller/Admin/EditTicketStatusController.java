package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ITicketStatusService;
import Service.Impl.TicketStatusServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/edit-ticketstatus"})
public class EditTicketStatusController extends HttpServlet{
	ITicketStatusService tsService = new TicketStatusServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idFL = req.getParameter("idFL");
		String idTC = req.getParameter("idTC");
		String totalseats = req.getParameter("totalseats");
		String emptyseats = req.getParameter("emptyseats");
		
		int totalint = Integer.parseInt(totalseats);
		int emptyint = Integer.parseInt(emptyseats);
		
		tsService.edit(idFL, idTC, totalint, emptyint);
		
		resp.sendRedirect("ticketstatus?idFL="+idFL);
	}

}
