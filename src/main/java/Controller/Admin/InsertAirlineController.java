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

import Model.AirlineModel;
import Model.FlightRoutesModel;
import Model.TicketClassModel;
import Service.IAirlineService;
import Service.IFlightRoutesService;
import Service.IPriceService;
import Service.ITicketClassService;
import Service.Impl.AirlineServiceImpl;
import Service.Impl.FlightRoutesServiceImpl;
import Service.Impl.PriceServiceImpl;
import Service.Impl.TicketClassServiceImpl;
import Util.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/add-airline"})
public class InsertAirlineController extends HttpServlet {
	IAirlineService alService = new AirlineServiceImpl();
	IFlightRoutesService frService = new FlightRoutesServiceImpl();
	ITicketClassService tcService = new TicketClassServiceImpl();
	IPriceService priceService = new PriceServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AirlineModel airline = new AirlineModel();
		
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
				if (item.getFieldName().equals("nameAL")) {
					airline.setNameAL(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						String filename = item.getName();
						int index = filename.lastIndexOf(".");
						String name = airline.getNameAL();
						name = name.toLowerCase().replace(" ", "").concat(filename.substring(index));
						File file = new File(Constant.DIR + "logoairlines".concat("\\") + name);
						item.write(file);
						airline.setLogoAL(name);
					} else {
						airline.setLogoAL("");
					}
				}
			}
			
			alService.insert(airline);

			String idAL = alService.getIDNew();
			
			List<FlightRoutesModel> listfr = frService.getall();
			List<TicketClassModel> listtc = tcService.getAll();
			
			for (FlightRoutesModel fr : listfr) {
				for (TicketClassModel tc : listtc) {
					priceService.insert(fr.getIdFR(), tc.getIdTC(), idAL);
				}
			}
		
			resp.sendRedirect("airlines");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
