package com.luxoft.korzch.view;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.services.ClientService;
import com.luxoft.korzch.services.OrderService;
import com.luxoft.korzch.services.ProductService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static com.luxoft.korzch.util.Util.*;

public class AdminMenu implements Menu {

    private final ClientService clientService;
    private BufferedReader reader;

    public AdminMenu(ClientService clientService, ProductService productService, OrderService orderService) {
        this.clientService = clientService;
    }

    @Override
    public void showMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showMenuPanel();
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

    private void showClientOrders() {
        //todo showClientOrders
    }

    private void removeProduct() {
        //todo remove product
    }

    private void addProduct() {
        //todo add product
    }

    private void removeClient() throws IOException {
        System.out.println("input client id");
        long id = idToLong(reader.readLine());
        boolean success = clientService.removeClient(id);
        if(success){
            System.out.println("Client has been removed");
        }else {
            System.out.println("Client hasn't been found");
        }
    }

    private void getAllClients() {
        List<Client> clients = clientService.getAllClients();
        clients.forEach(client -> System.out.println(client.toString()));
        if(clients.isEmpty()){
            System.out.println("Sorry, there are not clients in the database");
        }
    }

    private void getClient() throws IOException {
        System.out.println("input client id");
        long id = idToLong(reader.readLine());
        if (id > 0) {
            Client client = clientService.getClient(id);
            if (client != null) {
                System.out.println(client.toString());
            } else {
                System.out.println("Client hasn't been found");
            }
        } else {
            System.out.println("Wrong id");
        }
    }

    private void modifyClient() throws IOException {
        System.out.println("input client id");
        long id = idToLong(reader.readLine());
        if (id > 0) {
            System.out.println("input email");
            String email = reader.readLine();
            System.out.println("input age");
            int age = ageToInt(reader.readLine());
            boolean success = clientService.updateClient(id, email, age);
            if (success) {
                System.out.println("Client has been updated");
            } else {
                System.out.println("Client hasn't been found");
            }
        } else {
            System.out.println("Client hasn't been found");
        }
    }

    private void createClient() throws IOException {
        System.out.println("input name");
        String name = reader.readLine();
        System.out.println("input last name");
        String lastName = reader.readLine();
        System.out.println("input phone");
        String phone = reader.readLine();
        boolean success = clientService.createClient(name, lastName, phone);
        if (success) {
            System.out.println("Client has been created");
        } else {
            System.out.println("Sorry we can't create such client");
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
