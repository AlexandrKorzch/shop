package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;

public interface SessionService {

    /**
     * todo add documentation
     * */
    boolean clearSession();

    /**
     * todo add documentation
     * */
    String isClientLoggedIn();

    /**
     * todo add documentation
     * */
    boolean loginClient(String id);

    /**
     * todo add documentation
     * */
    void logOut();

    /**
     * todo add documentation
     * */
    void setClientService(ClientService clientService);

}
