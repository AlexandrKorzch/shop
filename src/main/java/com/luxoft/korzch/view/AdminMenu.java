package com.luxoft.korzch.view;

import com.luxoft.korzch.services.ClientService;

import java.io.BufferedReader;
import java.io.IOException;

public class AdminMenu implements Menu {

    private final ClientService clientService;
    private BufferedReader reader;

    public AdminMenu(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void showMenu() {
        showCases();

        boolean isRunning = true;

        while (isRunning) {

            try {
                switch (reader.readLine()) {
                    case "1": {
                        createClient();
                        break;
                    }
                    case "2": {
//                    clientMenu.showMenu();
                        break;
                    }
                    case "3": {
//                    isRunning = false;
                        break;
                    }
                    case "4": {
//                    isRunning = false;
                        break;
                    }
                    case "5": {
//                    isRunning = false;
                        break;
                    }
                    case "9": {
                    isRunning = false;
                        break;
                    }
                    case "0": {
//                    isRunning = false;
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

    private void createClient() throws IOException {
        System.out.println("input name");
        String name = reader.readLine();
        System.out.println("last name");
        String lastName = reader.readLine();
        System.out.println("input phone");
        String phone = reader.readLine();
        clientService.createClient(name, lastName, phone);
    }

    private void showCases() {
        System.out.println("1. Add client");
        System.out.println("2. Modify client");
        System.out.println("3. Remove client");
        System.out.println("4. List all client");
        System.out.println("5. Add product");
        System.out.println("9. Return");
        System.out.println("0. Exist");
    }

    void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}
