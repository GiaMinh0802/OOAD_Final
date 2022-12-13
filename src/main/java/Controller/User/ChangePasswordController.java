package Controller.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AccountModel;
import Service.IAccountService;
import Service.Impl.AccountServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/changepass"})
public class ChangePasswordController extends HttpServlet {

	IAccountService accService = new AccountServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String currentpass = req.getParameter("currentpass");
		String newpass = req.getParameter("newpass");
		String confirmnewpass = req.getParameter("confirmnewpass");
		HttpSession session = req.getSession();
		Object account = session.getAttribute("account");
		AccountModel acc = (AccountModel) account;
		System.out.println(acc.getPass().strip().length());
		System.out.println(currentpass.length());
		if (acc.getPass().strip().equals(currentpass)) {
			if (newpass.equals(confirmnewpass)) {
				accService.changepassword(newpass, acc.getIdUS());
				resp.sendRedirect(req.getContextPath() + "/sign-out");
			} else {
				req.setAttribute("noti", "Passwords do not match!");
				req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
			}
			
		} else {
			req.setAttribute("noti", "Incorrect password!");
			req.getRequestDispatcher("/views/user/my-profile.jsp").forward(req, resp);
		}
	}

}
