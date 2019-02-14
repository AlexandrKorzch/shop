package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    private List<Client> clients = new ArrayList<>();

    @Override
    public boolean saveClient(Client client) {
        client.setId(clients.size()+1);
        clients.add(client);
        return true;
    }

    @Override
    public boolean removeClient(long id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                clients.remove(client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateClient(long id, String email ,int age) {
        for (Client client : clients) {
            if (client.getId() == id) {
                if (age > 0) {
                    client.setAge(client.getAge());
                }
                if (email != null) {
                    client.setEmail(client.getEmail());
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Client getClient(long id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return clients;
    }
}
