package com.luxoft.korzch.view;

import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.ClientService;
import com.luxoft.korzch.services.OrderService;
import com.luxoft.korzch.services.ProductService;
import com.luxoft.korzch.services.SessionService;
import com.luxoft.korzch.session.LoggedIn;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static com.luxoft.korzch.util.Util.*;

public class ClientMenu implements Menu {

    private final SessionService sessionService;
    private final ClientService clientService;
    private final ProductService productService;
    private final OrderService orderService;
    private BufferedReader reader;

    public ClientMenu(ClientService clientService,
                      ProductService productService,
                      OrderService orderService,
                      SessionService sessionService) {
        this.clientService = clientService;
        this.productService = productService;
        this.orderService = orderService;
        this.sessionService = sessionService;
    }

    @Override
    public void showMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showMenuPanel();
            try {
                switch (reader.readLine()) {
                    case "1": {
                        login();
                        break;
                    }
                    case "2": {
                        showAllProducts();
                        break;
                    }
                    case "3": {
                        addProductToBasket();
                        break;
                    }
                    case "4": {
                        showBasket();
                        break;
                    }
                    case "5": {
                        removeProductFromBasket();
                        break;
                    }
                    case "6": {
                        showOrders();
                        break;
                    }
                    case "9": {
//                        sessionService.logOut();
                        isRunning = false;
                        break;
                    }
                    case "0": {
                        closeProgram();
                        break;
                    }
                    default: {
                        System.out.println("Wrong input");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void login() throws IOException {
        System.out.println("input client id");
        String id = reader.readLine();
        boolean success = sessionService.loginClient(id);
        if (success) {
            System.out.println("You are logged in. Well come!!!");
        } else {
            System.out.println("Please contact the Administrator");
        }
    }

    private void showOrders() throws IOException {
        isClientLoggedIn(clientId -> {
            List<Order> orders = orderService.getClientOrders(clientId);
            if (isNotEmpty(orders)) {
                orders.forEach(order -> System.out.println(order.toString()));
            } else {
                System.out.println("Sorry, You don't have orders");
            }
        });
    }

    private void removeProductFromBasket() throws IOException {
        isClientLoggedIn(clientId -> {
            System.out.println("input product id");
            String id = reader.readLine();
            boolean success = clientService.removeProductFromBasket(id);
            if(success){
                System.out.println("Product has been removed from you basket");
            }else {
                System.out.println("Product hasn't been found in you basket");
            }
        });
    }

    private void showBasket() throws IOException {
        isClientLoggedIn(clientId -> {
            List<Product> products = clientService.getBasket(clientId);
            if (isNotEmpty(products)) {
                products.forEach(product -> System.out.println(product.toString()));
            } else {
                System.out.println("Sorry, You don't have products in your basket");
            }
        });
    }

    private void addProductToBasket() throws IOException {
        isClientLoggedIn(clientId -> {
            System.out.println("input product id");
            String id = reader.readLine();
            boolean success = clientService.addProductToBasket(id);
            if(success){
                System.out.println("Product has been removed from you basket");
            }else {
                System.out.println("Products haven't been found in you basket");
            }
        });
    }

    private void showAllProducts() throws IOException {
        isClientLoggedIn(clientId -> {
            List<Product> products = productService.getAllProducts();
            if (isNotEmpty(products)) {
                products.forEach(product -> System.out.println(product.toString()));
            } else {
                System.out.println("Sorry, there are not products in this shop");
            }
        });
    }

    private void isClientLoggedIn(LoggedIn loggedIn) throws IOException {
        String clientId = sessionService.isClientLoggedIn();
        if (isNotNull(clientId)) {
            loggedIn.isLoggedIn(clientId);
        } else {
            System.out.println("Please Log In");
        }
    }

    private void showMenuPanel() {
        System.out.println();
        System.out.println("-------Client menu------");
        System.out.println("1. Login");
        System.out.println("2. Show all products");
        System.out.println("3. Add product to basket");
        System.out.println("4. Show basket");
        System.out.println("5. Remove from basket");
        System.out.println("6. Show orders");
        System.out.println("9. Return");
        System.out.println("0. Exit");
    }

    void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}

