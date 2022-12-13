package Controller.Seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AccountModel;
import Model.UserModel;
import Service.IUserService;
import Service.Impl.UserServiceImpl;
import Util.Function;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/seller/myprofile"})
public class MyProfileController extends HttpServlet{
	IUserService usService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object account = session.getAttribute("account");
		if (account != null) {
			req.getRequestDispatcher("/views/user/my-profile.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("sign-in");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String birthday = req.getParameter("birthday");
		birthday = Function.convertDateForSQL(birthday);
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		HttpSession session = req.getSession();
		Object account = session.getAttribute("account");
		UserModel us = null;
		if (account != null) {
			AccountModel acc = (AccountModel) account;
			us = new UserModel(acc.getIdUS(), fullname, phone, birthday, Integer.parseInt(gender) , address);
			usService.edit(us);
			us = usService.getbyID(acc.getIdUS());
			String date = Function.convertDateForJSP(us.getBirthdayUS());
			us.setBirthdayUS(date);
			session.setAttribute("user", us);
			req.getRequestDispatcher("/views/user/my-profile.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("sign-in");
		}
	}
}
