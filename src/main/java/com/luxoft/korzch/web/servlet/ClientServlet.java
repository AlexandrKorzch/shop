package com.luxoft.korzch.web.servlet;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.luxoft.korzch.util.Util.ageToInt;
import static com.luxoft.korzch.util.Util.idToLong;


public class ClientServlet extends HttpServlet {

    private ClientService<Client> clientService;

    public ClientServlet() {
    }

    public ClientServlet(ClientService clientService) {
        this.clientService = clientService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        if("/clients".equals(request.getServletPath()) && "/basket".equals(request.getPathInfo())){
            showBasket(response);
        }else if("/clients".equals(request.getServletPath()) && "/update".equals(request.getPathInfo())){
            updateClient(request, response);
        }else if("/clients".equals(request.getServletPath())){
            showAllClients(response);
        }
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String age = request.getParameter("age");
        boolean success = clientService.update(new Client(idToLong(id), email, ageToInt(age), phone));
        if(success){
            out.println("Success");
        }else {
            out.println("Something went wrong");
        }
    }

    private void showBasket(HttpServletResponse response)  throws IOException {
        List<Product> products = clientService.getBasket();
        PrintWriter out = response.getWriter();
        out.println("<table  border=\"5\" cellpadding=\"7\" width=\"100%\">");
        products.forEach(product -> {
            out.println("<tr>");
            out.print("<td>" + product.getId() + "</td>");
            out.print("<td>" + product.getName() + "</td>");
            out.print("<td>" + product.getPrice() + "</td>");
            out.print("</tr>");
        });
        out.println("</table>");
    }

    private void showAllClients(HttpServletResponse response) throws IOException {
        List<Client> all = clientService.getAll();
        PrintWriter out = response.getWriter();
        out.println("<table  border=\"5\" cellpadding=\"7\" width=\"100%\">");
        all.forEach(client -> {
            out.println("<tr>");
            out.print("<td>" + client.getId() + "</td>");
            out.print("<td>" + client.getName() + "</td>");
            out.print("<td>" + client.getLastName() + "</td>");
            out.print("<td>" + client.getPhone() + "</td>");
            out.print("<td>" + client.getEmail() + "</td>");
            out.print("<td>" + client.getAge() + "</td>");
            out.print("</tr>");
        });
        out.println("</table>");
    }
}
