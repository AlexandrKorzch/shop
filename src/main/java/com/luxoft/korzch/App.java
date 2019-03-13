package com.luxoft.korzch;

import com.luxoft.korzch.database.DBConnectionProvider;
import com.luxoft.korzch.database.TablesCRUD;
import com.luxoft.korzch.database.TablesCRUDIml;
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

        DBConnectionProvider dbConnectionProvider = new DBConnectionProvider();

        TablesCRUD tablesCRUD = new TablesCRUDIml(dbConnectionProvider);
        tablesCRUD.createProductTable();
        tablesCRUD.createClientTable();
        tablesCRUD.createBasketTable();
        tablesCRUD.createOrderTable();

        ProductDao<Product> productDao = new ProductDaoImpl(dbConnectionProvider);
        ClientDao<Client> clientDao = new ClientDaoImpl(dbConnectionProvider);
        BasketDao basketDao = new BasketDaoImpl(dbConnectionProvider);
        OrderDao<Order> orderDao = new OrderDaoImpl(dbConnectionProvider);

        Session<Client> session = new Session<>();
        SessionService sessionService = new SessionServiceImpl(session);

        ClientService<Client> clientService = new ClientServiceImpl(clientDao, productDao, basketDao, orderDao, sessionService);
        ProductService<Product> productService = new ProductServiceImpl(productDao);
        OrderService<Order> orderService = new OrderServiceImpl(orderDao, sessionService);

        sessionService.setClientService(clientService);

        AdminMenu adminMenu = new AdminMenu(clientService, productService, orderService);
        ClientMenu clientMenu = new ClientMenu(clientService, productService, orderService, sessionService);

        MainMenu menu = new MainMenu(adminMenu, clientMenu);
        menu.showMenu();
    }
}
