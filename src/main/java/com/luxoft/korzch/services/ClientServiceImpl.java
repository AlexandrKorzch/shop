package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.ClientDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.session.Session;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private final SessionService sessionService;

    public ClientServiceImpl(ClientDao clientDao, SessionService sessionService) {
        this.clientDao = clientDao;
        this.sessionService = sessionService;
    }

    @Override
    public boolean createClient(String name, String lastName, String phone) {
        return clientDao.saveClient(new Client(name, lastName, phone));
    }

    @Override
    public boolean removeClient(long id) {
        return clientDao.removeClient(id);
    }

    @Override
    public boolean updateClient(long id, String email ,int age) {
        return clientDao.updateClient(id, email , age);
    }

    @Override
    public Client getClient(long id) {
        return clientDao.getClient(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }
}
