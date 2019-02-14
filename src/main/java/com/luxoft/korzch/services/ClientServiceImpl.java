package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.ClientDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;

import java.util.List;

import static com.luxoft.korzch.util.Util.ageToInt;
import static com.luxoft.korzch.util.Util.idToLong;

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
    public boolean removeClient(String id) {
        return clientDao.removeClient(idToLong(id));
    }

    @Override
    public boolean updateClient(String id, String email, String age) {
        return clientDao.updateClient(idToLong(id), email, ageToInt(age));
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    @Override
    public boolean removeProductFromBasket(String id) {
        return false;
    }

    @Override
    public boolean addProductToBasket(String id) {
        return false;
    }

    @Override
    public Client getClient(String id) {
        return null;
    }

    @Override
    public List<Product> getBasket(String clientId) {
        return null;
    }
}
