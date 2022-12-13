package Controller.Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AccountModel;
import Model.UserModel;
import Service.IAccountService;
import Service.IUserService;
import Service.Impl.AccountServiceImpl;
import Service.Impl.UserServiceImpl;
import Util.Function;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/sign-in", "/seller/sign-out"})
public class SignInController extends HttpServlet {
	IAccountService accService = new AccountServiceImpl();
	IUserService usService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/web/sign-in.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		AccountModel acc = accService.login(email, pass);
		UserModel us = null;
		if (acc != null) {
			HttpSession session = req.getSession();
			session.setAttribute("account", acc);
			us = usService.getbyID(acc.getIdUS());
			String date = Function.convertDateForJSP(us.getBirthdayUS());
			us.setBirthdayUS(date);
			session.setAttribute("user", us);
			if (session.getAttribute("infoflight") != null) {
				if (session.getAttribute("infobooking") != null) {
					resp.sendRedirect(req.getContextPath() + "/flight-detail");
				} else {
					resp.sendRedirect(req.getContextPath() + "/flight-list");
				}
			} else {
				if (acc.getType() == 1) {
					resp.sendRedirect(req.getContextPath() + "/admin");
				} else if (acc.getType() == -1) {
					if (acc.getStatus() == 1) {
						resp.sendRedirect(req.getContextPath() + "/seller/home");
					} else {
						req.setAttribute("mess", "Your account has been locked!");
						req.getRequestDispatcher("/views/web/sign-in.jsp").forward(req, resp);
					}
				}
				else {
					if (acc.getStatus() == 1) {
						resp.sendRedirect(req.getContextPath() + "/home");
					} else {
						req.setAttribute("mess", "Your account has been locked!");
						req.getRequestDispatcher("/views/web/sign-in.jsp").forward(req, resp);
					}
				}
			}
			
		}
		else {
			req.setAttribute("mess", "Incorrect email or password!");
			req.getRequestDispatcher("/views/web/sign-in.jsp").forward(req, resp);
		}
	}
}
