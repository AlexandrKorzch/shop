package com.luxoft.korzch.web;

import com.luxoft.korzch.database.DBConnectionProvider;
import com.luxoft.korzch.database.dao.BasketDaoImpl;
import com.luxoft.korzch.database.dao.ClientDaoImpl;
import com.luxoft.korzch.database.dao.OrderDaoImpl;
import com.luxoft.korzch.database.dao.ProductDaoImpl;
import com.luxoft.korzch.database.dao.base.BasketDao;
import com.luxoft.korzch.database.dao.base.ClientDao;
import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.jdbc.ClientServiceImpl;
import com.luxoft.korzch.services.jdbc.SessionServiceImpl;
import com.luxoft.korzch.services.ClientService;
import com.luxoft.korzch.services.SessionService;
import com.luxoft.korzch.session.Session;
import com.luxoft.korzch.web.servlet.ClientServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApp implements ServletContextListener {

    DBConnectionProvider dbConnectionProvider = new DBConnectionProvider();

    ProductDao<Product> productDao = new ProductDaoImpl(dbConnectionProvider);
    ClientDao<Client> clientDao = new ClientDaoImpl(dbConnectionProvider);
    BasketDao basketDao = new BasketDaoImpl(dbConnectionProvider);
    OrderDao<Order> orderDao = new OrderDaoImpl(dbConnectionProvider);

    Session<Client> session = new Session<>();
    SessionService sessionService = new SessionServiceImpl(session);

    ClientService clientService = new ClientServiceImpl(clientDao, productDao, basketDao, orderDao, sessionService);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext
                .addServlet("ClientServlet", new ClientServlet(clientService))
                .addMapping("/clients/*");
    }
}
