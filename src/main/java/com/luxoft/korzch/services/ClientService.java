package com.luxoft.korzch.services;

public interface ClientService {

    /**
     * todo add documentation
     * */
    void createClient(String name, String lastName, String phone);

    /**
     * todo add documentation
     * */
    void removeClient(String name, String lastName, String phone);
}
