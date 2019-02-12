package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;

import java.util.List;

public interface ClientService {

    /**
     * todo add documentation
     * */
    boolean createClient(String name, String lastName, String phone);

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
