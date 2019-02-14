package com.luxoft.korzch.session;

import com.luxoft.korzch.domain.Client;

public class Session {

    private Client currentClient;

    public Client getCurrentClient() {
        return currentClient;
    }

    public boolean setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
        return true;
    }

    public boolean clearSession() {
        currentClient = null;
        return true;
    }
}
