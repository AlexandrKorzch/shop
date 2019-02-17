package com.luxoft.korzch;

import com.luxoft.korzch.dao.ClientDaoImpl;
import com.luxoft.korzch.dao.OrderDaoImpl;
import com.luxoft.korzch.dao.ProductDaoImpl;
import com.luxoft.korzch.dao.base.ClientDao;
import com.luxoft.korzch.dao.base.OrderDao;
import com.luxoft.korzch.dao.base.ProductDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.ClientServiceImpl;
import com.luxoft.korzch.services.OrderServiceImpl;
import com.luxoft.korzch.services.ProductServiceImpl;
import com.luxoft.korzch.services.SessionServiceImpl;
import com.luxoft.korzch.services.base.ClientService;
import com.luxoft.korzch.services.base.OrderService;
import com.luxoft.korzch.services.base.ProductService;
import com.luxoft.korzch.services.base.SessionService;
import com.luxoft.korzch.session.Session;
import com.luxoft.korzch.view.AdminMenu;
import com.luxoft.korzch.view.ClientMenu;
import com.luxoft.korzch.view.MainMenu;

public class App {

    public static void main(String[] args) {

        Session<Client> session = new Session<>();

        ProductDao<Product> productDao = new ProductDaoImpl<>();
        ClientDao<Client> clientDao = new ClientDaoImpl<>();
        OrderDao<Order> orderDao = new OrderDaoImpl<>();

        SessionService sessionService = new SessionServiceImpl(session);

        ClientService<Client> clientService = new ClientServiceImpl<>(sessionService, clientDao, productDao);
        OrderService orderService = new OrderServiceImpl<>(sessionService, orderDao);
        ProductService productService = new ProductServiceImpl<>(productDao);

        sessionService.setClientService(clientService);

        AdminMenu adminMenu = new AdminMenu(clientService, productService, orderService);
        ClientMenu clientMenu = new ClientMenu(clientService, productService, orderService, sessionService);

        MainMenu menu = new MainMenu(adminMenu, clientMenu);
        menu.showMenu();
    }
}
