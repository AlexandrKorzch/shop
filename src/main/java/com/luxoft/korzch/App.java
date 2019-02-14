package com.luxoft.korzch;

import com.luxoft.korzch.dao.*;
import com.luxoft.korzch.services.*;
import com.luxoft.korzch.session.Session;
import com.luxoft.korzch.view.AdminMenu;
import com.luxoft.korzch.view.ClientMenu;
import com.luxoft.korzch.view.MainMenu;

public class App {

    public static void main(String[] args) {

        Session session = new Session();

        ProductDao productDao = new ProductDaoImpl();
        ClientDao clientDao = new ClientDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();

        SessionService sessionService = new SessionServiceImpl(session);
        ClientService clientService = new ClientServiceImpl(productDao, clientDao, sessionService);
        OrderService orderService = new OrderServiceImpl(orderDao, sessionService);
        ProductService productService = new ProductServiceImpl(productDao);

        sessionService.setClientService(clientService);

        AdminMenu adminMenu = new AdminMenu(clientService, productService, orderService);
        ClientMenu clientMenu = new ClientMenu(clientService, productService, orderService, sessionService);

        MainMenu menu = new MainMenu(adminMenu, clientMenu);
        menu.showMenu();
    }
}
