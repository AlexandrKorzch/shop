package com.luxoft.korzch.view;

import com.luxoft.korzch.services.ClientService;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientMenu implements Menu{

    private final ClientService clientService;
    private BufferedReader reader;

    public ClientMenu(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void showMenu() {
        showCases();

        try {
            switch (reader.readLine()) {
                case "1": {
//                    adminMenu.showMenu();
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
//                    isRunning = false;
                    break;
                }
//                case "0": {
////                    isRunning = false;
//                    break;
//                }
                default: {
                    System.out.println("Wrong input");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCases() {
        System.out.println("1. Admin");
        System.out.println("2. Client");
        System.out.println("0. Exit");
    }

    void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}
