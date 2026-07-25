package servlet;

import java.io.IOException;

import dao.ServiceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Service;

@WebServlet("/editService")
public class EditServiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int serviceId = Integer.parseInt(request.getParameter("id"));

        ServiceDAO serviceDAO = new ServiceDAO();

        Service service = serviceDAO.getServiceById(serviceId);

        request.setAttribute("service", service);

        request.getRequestDispatcher("editService.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        String name = request.getParameter("name");
        int duration = Integer.parseInt(request.getParameter("duration"));
        double price = Double.parseDouble(request.getParameter("price"));

        Service service = new Service();

        service.setServiceId(serviceId);
        service.setName(name);
        service.setDurationMinutes(duration);
        service.setPrice(price);

        ServiceDAO serviceDAO = new ServiceDAO();

        boolean status = serviceDAO.updateService(service);

        if (status) {

            response.sendRedirect("manageServices");

        } else {

            response.sendRedirect("editService.jsp");

        }
    }
}