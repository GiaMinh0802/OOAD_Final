package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ITicketClassService;
import Service.Impl.TicketClassServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/edit-ticketclass"})
public class EditTicketClassController extends HttpServlet {
	ITicketClassService tcService = new TicketClassServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idTC = req.getParameter("idTC");
		String nameTC = req.getParameter("nameTC");
		
		tcService.edit(idTC, nameTC);
		
		resp.sendRedirect("ticketclasses");
	}

}
