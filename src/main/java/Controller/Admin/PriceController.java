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
import Model.PriceModel;
import Service.IPriceService;
import Service.Impl.PriceServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/prices"})
public class PriceController extends HttpServlet {
	IPriceService priceService = new PriceServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountModel account = (AccountModel) session.getAttribute("account");
		
		if (account != null) {
			if (account.getType() == 1) {
				String idFR = req.getParameter("idFR");
				String idAL = req.getParameter("idAL");
				
				List<PriceModel> listprice = priceService.getbyIdFRAndIdAL(idFR, idAL);
				
				req.setAttribute("listprice", listprice);
				req.getRequestDispatcher("/views/admin/price.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/sign-in");
		}	
	}

}
