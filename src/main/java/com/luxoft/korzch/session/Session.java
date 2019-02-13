package com.luxoft.korzch.session;

import com.luxoft.korzch.domain.Client;

public class Session {

    private Client currentClient;

    public Client getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(Client currentClient) {
        this.currentClient = currentClient;
    }

    public void clearSession(){
        currentClient = null;
    }
}
