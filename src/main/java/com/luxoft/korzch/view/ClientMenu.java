package com.luxoft.korzch.view;

import com.luxoft.korzch.services.ClientService;
import com.luxoft.korzch.services.OrderService;
import com.luxoft.korzch.services.ProductService;
import com.luxoft.korzch.services.SessionService;

import java.io.BufferedReader;
import java.io.IOException;

import static com.luxoft.korzch.util.Util.closeProgram;

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

    private void showOrders() {
        //todo show orders
    }

    private void login() throws IOException {
        //todo login()
        System.out.println("input client id");
        String id = reader.readLine();
        clientService.loginClient(id);
    }

    private void removeProductFromBasket() {
        //todo removeProductFromBasket
    }

    private void showBasket() {
        //todo showBasket
    }

    private void addProductToBasket() {
        //todo addProductToBasket()
    }

    private void showAllProducts() {
        //todo showAllProducts
    }

    private void showMenuPanel() {
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
