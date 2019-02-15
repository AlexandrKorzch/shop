package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientDaoImpl implements ClientDao {

    private Map<Long, Client> clients = new HashMap<>();
    private static long id = 0;

    private static final ClientDao instance = new ClientDaoImpl();

    private ClientDaoImpl(){}

    public static ClientDao getInstance(){
        return instance;
    }

    @Override
    public boolean saveClient(Client client) {
        clients.put(id, client);
        id++;
        return true;
    }

    @Override
    public boolean removeClient(long id) {
        clients.remove(id);
        return true;
    }

    @Override
    public boolean updateClient(long id, String email, int age) {
        Client client = clients.get(id);
        if (age > 0) {
            client.setAge(client.getAge());
        }
        if (email != null) {
           client.setEmail(client.getEmail());
        }
        return true;
    }

    @Override
    public Client getClient(long id) {
        return clients.get(id);
    }

    @Override
    public ArrayList<Client> getAllClients() {
        return new ArrayList<>(clients.values());
    }
}
