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

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/sign-up"})
public class SignUpController extends HttpServlet {
	IAccountService accService = new AccountServiceImpl();
	IUserService usService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/web/sign-up.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String pass = req.getParameter("psw-input");
		String passconf = req.getParameter("pswconfirm-input");
		if (pass.equals(passconf)) {
			String id = null;
			if (usService.checkUserexist(name, phone) == 1) {
				id = usService.getnewInsert();
			} else {
				UserModel user = new UserModel(null, name, phone, null, 1, null);
				usService.insert(user);
				id = usService.getnewInsert();
			}
			AccountModel acc = new AccountModel(email, pass, id, 1, 0);
			accService.insert(acc);
			HttpSession session = req.getSession();
			session.setAttribute("account", acc);
			resp.sendRedirect(req.getContextPath() + "/myprofile");
		} else {
			req.setAttribute("notification", "Passwords do not match!");
			req.getRequestDispatcher("/views/web/sign-up.jsp").forward(req, resp);
		}
	}
}
