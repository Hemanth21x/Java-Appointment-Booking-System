package servlet;

import java.io.IOException;
import java.util.List;

import dao.ServiceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Service;

@WebServlet("/services")
public class ServiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Create DAO object
        ServiceDAO serviceDAO = new ServiceDAO();

        // Step 2: Get all services
        List<Service> services = serviceDAO.getAllServices();

        // Step 3: Store data in request
        request.setAttribute("services", services);

        // Step 4: Forward to JSP
        request.getRequestDispatcher("services.jsp")
               .forward(request, response);
    }
}