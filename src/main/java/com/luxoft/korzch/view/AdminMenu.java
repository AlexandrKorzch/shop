package com.luxoft.korzch.view;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.base.ClientService;
import com.luxoft.korzch.services.base.OrderService;
import com.luxoft.korzch.services.base.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static com.luxoft.korzch.util.Util.*;

public class AdminMenu implements Menu {

    private final ClientService<Client> clientService;
    private final ProductService productService;
    private final OrderService orderService;
    private BufferedReader reader;

    public AdminMenu(ClientService<Client> clientService,
                     ProductService productService,
                     OrderService orderService) {
        this.clientService = clientService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @Override
    public void showMenu() {
        showMenuPanel();
        boolean isRunning = true;
        while (isRunning) {
            try {
                switch (reader.readLine()) {
                    case "1": {
                        createClient();
                        break;
                    }
                    case "2": {
                        modifyClient();
                        break;
                    }
                    case "3": {
                        getClient();
                        break;
                    }
                    case "4": {
                        removeClient();
                        break;
                    }
                    case "5": {
                        getAllClients();
                        break;
                    }
                    case "6": {
                        addProduct();
                        break;
                    }
                    case "7": {
                        removeProduct();
                        break;
                    }
                    case "8": {
                        showClientOrders();
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
    private void createClient() throws IOException {
        System.out.println("input name");
        String name = reader.readLine();
        System.out.println("input last name");
        String lastName = reader.readLine();
        System.out.println("input phone in format (000)-000-00-00");
        String phone = reader.readLine();
        boolean success = clientService.create(new Client(name, lastName, phone));
        if (success) {
            System.out.println("Client has been created");
        } else {
            System.out.println("Sorry we can't create such client");
        }
    }

    //2
    private void modifyClient() throws IOException {
        System.out.println("input client id");
        String clientId = reader.readLine();
        System.out.println("input email in right format");
        String email = reader.readLine();
        System.out.println("input age");
        String age = reader.readLine();
        boolean success = clientService.update(idToLong(clientId), email, ageToInt(age));
        if (success) {
            System.out.println("Client has been updated");
        } else {
            System.out.println("Client hasn't been found");
        }
    }

    //3
    private void getClient() throws IOException {
        System.out.println("input client id");
        long id = idToLong(reader.readLine());
        Client client = clientService.get(id);
        if (client != null) {
            System.out.println(client.toString());
        } else {
            System.out.println("Client hasn't been found");
        }
    }

    //4
    private void removeClient() throws IOException {
        System.out.println("input client id");
        String clientId = reader.readLine();
        boolean success = clientService.delete(idToLong(clientId));
        if (success) {
            System.out.println("Client has been removed");
        } else {
            System.out.println("Client hasn't been found");
        }
    }

    //5
    private void getAllClients() {
        List clients = clientService.getAll();
        clients.forEach(client -> System.out.println(client.toString()));
        if (clients.isEmpty()) {
            System.out.println("Sorry, there are not clients in the database");
        }
    }

    //6
    private void addProduct() throws IOException {
        System.out.println("add product name");
        String productName = reader.readLine();
        System.out.println("add product price");
        String productPrice = reader.readLine();
        boolean success = productService.create(new Product(productName, priceToDouble(productPrice)));
        if (success) {
            System.out.println("new product has been added");
        } else {
            System.out.println("unfortunately product can't be added");
        }
    }


    //7
    private void removeProduct() throws IOException {
        System.out.println("enter product id");
        String productId = reader.readLine();
        boolean success = productService.delete(idToLong(productId));
        if (success) {
            System.out.println("product has been removed");
        } else {
            System.out.println("product hasn't been removed");
        }
    }

    //8
    private void showClientOrders() throws IOException {
        System.out.println("enter client id");
        long id = idToLong(reader.readLine());
        List ordersList = orderService.getClientOrders(id);
        if (isNotNullNotEmpty(ordersList)) {
            ordersList.forEach(order -> System.out.println(order.toString()));
        } else {
            System.out.println("This client don't have any orders");
        }
    }

    private void showMenuPanel() {
        System.out.println();
        System.out.println("-------Admin menu------");
        System.out.println("1. Add client");
        System.out.println("2. Modify client");
        System.out.println("3. Show client");
        System.out.println("4. Remove client");
        System.out.println("5. List all client");
        System.out.println("6. Add product");
        System.out.println("7. Remove product");
        System.out.println("8. Show client orders");
        System.out.println("9. Return");
        System.out.println("0. Exit");
    }

    void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}
