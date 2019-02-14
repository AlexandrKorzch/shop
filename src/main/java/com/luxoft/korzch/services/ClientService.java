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
    boolean removeClient(String id);

    /**
     * todo add documentation
     * */
    boolean updateClient(String id, String email , String age);

    /**
     * todo add documentation
     * */
    Client getClient(String id);

    /**
     * todo add documentation
     * */
    List<Client> getAllClients();

    /**
     * todo add documentation
     * */
    boolean loginClient(String id);
}
