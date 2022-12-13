package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.IAccountService;
import Service.Impl.AccountServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/unlock"})
public class UnlockUserController extends HttpServlet {
	IAccountService accService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idUS = req.getParameter("idCus");
		
		accService.unlockuser(idUS);
		resp.sendRedirect("customers");
	}
}
