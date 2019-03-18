package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;

public interface SessionService {

    /**
     * TODO add documentation
     * */
    boolean isClientLoggedIn();

    /**
     * TODO add documentation
     *
     * @param id*/
    void loginClient(long id);

    /**
     * TODO add documentation
     * */
    void logOut();

    /**
     * TODO add documentation
     * */
    Client getCurrentClient();

    /**
     * TODO add documentation
     * */
    void setClientService(ClientService clientService);
}
