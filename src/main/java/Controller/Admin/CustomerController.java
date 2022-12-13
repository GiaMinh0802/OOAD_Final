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
import Model.UserAndAccountModel;
import Service.IUserService;
import Service.Impl.UserServiceImpl;
import Util.Function;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/customers"})
public class CustomerController extends HttpServlet{
	IUserService usService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		if (account != null) {
			if (account.getType() == 1) {
				List<UserAndAccountModel> listcus = usService.getforAdmin();
				
				for (UserAndAccountModel cus : listcus) {
					cus.setBirthdayUS(Function.convertDateForJSP(cus.getBirthdayUS()));
				}
				
				req.setAttribute("listcus", listcus);
				req.getRequestDispatcher("/views/admin/customer.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/sign-in");
		}	
	}

}
