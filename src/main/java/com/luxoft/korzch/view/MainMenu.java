package com.luxoft.korzch.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu implements Menu {


    private final AdminMenu adminMenu;
    private final ClientMenu clientMenu;

    private final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public MainMenu(AdminMenu adminMenu, ClientMenu clientMenu) {
        this.adminMenu = adminMenu;
        this.clientMenu = clientMenu;
        adminMenu.setReader(reader);
        clientMenu.setReader(reader);
    }

    @Override
    public void showMenu() {

        boolean isRunning = true;

        while (isRunning) {

            showCases();

            try {
                switch (reader.readLine()) {
                    case "1": {
                        adminMenu.showMenu();
                        break;
                    }
                    case "2": {
                        clientMenu.showMenu();
                        break;
                    }
                    case "0": {
                        isRunning = false;
                        break;
                    }
                    default: {
                        System.out.println("Wrong input");
                    }
                }
            } catch (IOException e) {
                isRunning = false;
                e.printStackTrace();
            }
        }
    }

    private void showCases() {
        System.out.println("1. Admin");
        System.out.println("2. Client");
        System.out.println("0. Exit");
    }
}
