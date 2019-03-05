package com.luxoft.korzch.view;

import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.base.ClientService;
import com.luxoft.korzch.services.base.OrderService;
import com.luxoft.korzch.services.base.ProductService;
import com.luxoft.korzch.services.base.SessionService;
import com.luxoft.korzch.session.LoggedIn;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static com.luxoft.korzch.util.Util.*;

public class ClientMenu implements Menu {

    private final ClientService clientService;
    private final ProductService productService;
    private final OrderService orderService;
    private final SessionService sessionService;
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
        showMenuPanel();
        boolean isRunning = true;
        while (isRunning) {
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

    //1
    private void login() throws IOException {
        sessionService.logOut();
        System.out.println("input client id");
        String id = reader.readLine();
        sessionService.loginClient(idToLong(id));
        boolean loggedIn = sessionService.isClientLoggedIn();
        if (loggedIn) {
            System.out.println("You are logged in. Well come!!!");
        } else {
            System.out.println("Please contact the Administrator");
        }
    }

    //2
    private void showAllProducts() throws IOException {
        isClientLoggedIn(() -> {
            List products = productService.getAll();
            if (isNotNullNotEmpty(products)) {
                products.forEach(product -> System.out.println(product.toString()));
            } else {
                System.out.println("Sorry, there are not products in this shop");
            }
        });
    }

    //3
    private void addProductToBasket() throws IOException {
        isClientLoggedIn(() -> {
            System.out.println("input product id");
            String productId = reader.readLine();
            boolean success = clientService.addProductToBasket(idToLong(productId));
            if (success) {
                System.out.println("Product has been added to your4 basket");
            } else {
                System.out.println("Products haven't been added to your basket");
            }
        });
    }

    //4
    private void showBasket() throws IOException {
        isClientLoggedIn(() -> {
            List<Product> products = clientService.getBasket();
            if (isNotNullNotEmpty(products)) {
                products.forEach(product -> System.out.println(product.toString()));
            } else {
                System.out.println("Sorry, You don't have products in your basket");
            }
        });
    }

    //5
    private void removeProductFromBasket() throws IOException {
        isClientLoggedIn(() -> {
            System.out.println("input product id");
            long productId = idToLong(reader.readLine());
            boolean success = clientService.removeProductFromBasket(productId);
            if (success) {
                System.out.println("Product has been removed from you basket");
            } else {
                System.out.println("Product hasn't been found in you basket");
            }
        });
    }

    //6
    private void showOrders() throws IOException {
        isClientLoggedIn(() -> {
//            List<Order> orders = orderService.getClientOrders();
//            if (isNotNullNotEmpty(orders)) {
//                orders.forEach(order -> System.out.println(order.toString()));
//            } else {
//                System.out.println("Sorry, You don't have orders");
//            }
        });
    }

    private void isClientLoggedIn(LoggedIn loggedIn) throws IOException {
        boolean logged = sessionService.isClientLoggedIn();
        if (logged) {
            loggedIn.isLoggedIn();
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

