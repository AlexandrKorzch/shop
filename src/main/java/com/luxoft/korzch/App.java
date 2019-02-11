package com.luxoft.korzch;

import com.luxoft.korzch.dao.ClientDao;
import com.luxoft.korzch.dao.ClientDaoImpl;
import com.luxoft.korzch.services.ClientService;
import com.luxoft.korzch.services.ClientServiceImpl;
import com.luxoft.korzch.view.AdminMenu;
import com.luxoft.korzch.view.ClientMenu;
import com.luxoft.korzch.view.MainMenu;

public class App {

    public static void main(String[] args) {

        ClientDao clientDao = new ClientDaoImpl();

        ClientService clientService = new ClientServiceImpl(clientDao);

        AdminMenu adminMenu = new AdminMenu(clientService);
        ClientMenu clientMenu = new ClientMenu(clientService);

        MainMenu menu = new MainMenu(adminMenu, clientMenu);
        menu.showMenu();
    }
}
