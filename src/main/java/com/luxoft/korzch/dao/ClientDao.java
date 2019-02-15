package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Client;

import java.util.ArrayList;

public interface ClientDao {

    /**
     * TODO add documentation
     * */
    boolean saveClient(Client client);

    /**
     * TODO add documentation
     * */
    boolean removeClient(long id);

    /**
     * TODO add documentation
     * */
    boolean updateClient(long id, String email ,int age);

    /**
     * TODO add documentation
     * */
    Client getClient(long id);

    /**
     * TODO add documentation
     * */
    ArrayList<Client> getAllClients();
}
