package com.luxoft.korzch.web.servlet;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


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

//        if("/delete".equals(request.getPathInfo())){
//            deleteClient()
//        }

        // Set response content type
        response.setContentType("text/html");

        List<Client> all = clientService.getAll();

        // Actual logic goes here.
        PrintWriter out = response.getWriter();

        all.forEach(client -> {
            out.println("<h4>" + client + "</h4>");
        });
    }
}
