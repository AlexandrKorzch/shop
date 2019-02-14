package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Client;

import java.util.List;

public interface ClientDao {

    /**
     * todo add documentation
     * */
    boolean saveClient(Client client);

    /**
     * todo add documentation
     * */
    boolean removeClient(long id);

    /**
     * todo add documentation
     * */
    boolean updateClient(long id, String email ,int age);

    /**
     * todo add documentation
     * */
    Client getClient(long id);

    /**
     * todo add documentation
     * */
    List<Client> getAllClients();
}
