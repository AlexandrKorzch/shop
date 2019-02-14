package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;

public interface SessionService {
    void setCurrentClient(Client client);

    String isClientLoggedIn();

}
