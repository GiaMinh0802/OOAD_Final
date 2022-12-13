package Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.IPriceService;
import Service.Impl.PriceServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/edit-price"})
public class EditPriceController extends HttpServlet {
	IPriceService priceService = new PriceServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idFR = req.getParameter("idFR");
		String idTC = req.getParameter("idTC");
		String idAL = req.getParameter("idAL");
		String price = req.getParameter("price");
		
		int priceint = Integer.parseInt(price);
		
		priceService.edit(idFR, idTC, idAL, priceint);
		
		resp.sendRedirect("prices?idFR="+idFR+"&idAL="+idAL);
	}

}
