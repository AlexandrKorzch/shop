package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.ClientDao;
import com.luxoft.korzch.domain.Client;

public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void createClient(String name, String lastName, String phone) {
        clientDao.saveClient(new Client(name, lastName, phone));
    }

    @Override
    public void removeClient(String name, String lastName, String phone) {

    }
}
