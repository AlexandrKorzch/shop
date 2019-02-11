package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Client;

public class ClientDaoImpl implements ClientDao {

    @Override
    public boolean saveClient(Client client) {
        System.out.println("Client has been created - "+client.toString());
        return true;
    }

    @Override
    public boolean removeClient(Client client) {
        return true;
    }
}
