package servlet;

import java.io.IOException;

import dao.ServiceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deleteService")
public class DeleteServiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        int serviceId = Integer.parseInt(request.getParameter("id"));


        ServiceDAO dao = new ServiceDAO();


        boolean status = dao.deleteService(serviceId);


        response.sendRedirect("manageServices");

    }

}