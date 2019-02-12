package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Client;

import java.util.List;

public interface ClientDao {
    boolean saveClient(Client client);
    boolean removeClient(long id);
    boolean updateClient(long id, String email ,int age);
    Client getClient(long id);
    List<Client> getAllClients();
}
