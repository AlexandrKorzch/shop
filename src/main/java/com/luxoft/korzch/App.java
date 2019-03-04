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
import com.luxoft.korzch.domain.Basket;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.ClientServiceImpl;
import com.luxoft.korzch.services.OrderServiceImpl;
import com.luxoft.korzch.services.ProductServiceImpl;
import com.luxoft.korzch.services.base.ClientService;
import com.luxoft.korzch.services.base.OrderService;
import com.luxoft.korzch.services.base.ProductService;
import com.luxoft.korzch.view.AdminMenu;
import com.luxoft.korzch.view.ClientMenu;
import com.luxoft.korzch.view.MainMenu;

import static com.luxoft.korzch.util.Util.isNotNull;

public class App {

    public static void main(String[] args) {

        DBConnectionProvider database = new DBConnectionProvider();

        if (isNotNull(database.getConnection())) {

            TablesCRUD tablesCRUD = new TablesCRUDIml(database.getConnection());
            tablesCRUD.createProductTable();
            tablesCRUD.createClientTable();
            tablesCRUD.createBasketTable();
            tablesCRUD.createOrderTable();

            ProductDao<Product> productDao = new ProductDaoImpl(database.getConnection());
            ClientDao<Client> clientDao = new ClientDaoImpl(database.getConnection());
            BasketDao<Basket> basketDao = new BasketDaoImpl<>(database.getConnection());
            OrderDao<Order> orderDao = new OrderDaoImpl<>(database.getConnection());

            ClientService<Client> clientService = new ClientServiceImpl(clientDao, productDao, basketDao, orderDao);
            ProductService<Product> productService = new ProductServiceImpl(productDao);
            OrderService<Order> orderService = new OrderServiceImpl<>(orderDao);

            AdminMenu adminMenu = new AdminMenu(clientService, productService, orderService);
            ClientMenu clientMenu = new ClientMenu(clientService, productService, orderService);

            MainMenu menu = new MainMenu(adminMenu, clientMenu);
            menu.showMenu();
        }
    }
}
