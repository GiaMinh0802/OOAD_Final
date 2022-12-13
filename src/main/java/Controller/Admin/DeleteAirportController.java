package Controller.Admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.IAirportService;
import Service.Impl.AirportServiceImpl;
import Util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/delete-airport"})
public class DeleteAirportController extends HttpServlet {
	IAirportService apService = new AirportServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idAP = req.getParameter("idAP");
		String image = req.getParameter("image");
		
		apService.delete(idAP);
		
		try {
			File file = new File(Constant.DIR + "airport".concat("\\") + image);
			file.delete();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("airports");
	}
	
}
