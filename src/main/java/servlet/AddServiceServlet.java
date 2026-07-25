package servlet;

import java.io.IOException;

import dao.ServiceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Service;

@WebServlet("/addService")
public class AddServiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Step 1: Get form data
        String name = request.getParameter("name");
        int duration = Integer.parseInt(request.getParameter("duration"));
        double price = Double.parseDouble(request.getParameter("price"));

        // Step 2: Create Service object
        Service service = new Service();

        service.setName(name);
        service.setDurationMinutes(duration);
        service.setPrice(price);

        // Step 3: Create DAO object
        ServiceDAO serviceDAO = new ServiceDAO();

        // Step 4: Save service
        boolean status = serviceDAO.addService(service);

        // Step 5: Redirect
        if (status) {

            response.sendRedirect("manageServices");

        } else {

            response.sendRedirect("addService.jsp");

        }
    }
}