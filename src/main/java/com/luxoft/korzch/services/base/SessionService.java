package com.luxoft.korzch.services.base;

import com.luxoft.korzch.domain.Client;

public interface SessionService {

    /**
     * TODO add documentation
     * */
    long isClientLoggedIn();

    /**
     * TODO add documentation
     *
     * @param id*/
    boolean loginClient(long id);

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
