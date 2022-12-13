package Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Model.AirportModel;
import Service.IAirportService;
import Service.Impl.AirportServiceImpl;
import Util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/add-airport"})
public class InsertAirportController extends HttpServlet {
	IAirportService apService = new AirportServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AirportModel airport = new AirportModel();
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			@SuppressWarnings("unchecked")
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("idAP")) {
					airport.setIdAP(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("nameAP")) {
					airport.setNameAP(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("nameCity")) {
					airport.setCityAP(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String filename = item.getName();
						int index = filename.lastIndexOf(".");
						String name = airport.getCityAP();
						name = name.toLowerCase().replace(" ", "").concat(filename.substring(index));
						File file = new File(Constant.DIR + "airport".concat("\\") + name);
						item.write(file);
						airport.setImagePlace(name);
					} else {
						airport.setImagePlace("");
					}
				}
			}
			apService.insert(airport);
			resp.sendRedirect("airports");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
