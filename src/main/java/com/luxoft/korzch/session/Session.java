package com.luxoft.korzch.session;

import com.luxoft.korzch.domain.Client;

public class Session<T extends Client> {

    private T currentClient;

    public T getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(T currentClient) {
        this.currentClient = currentClient;
    }

    public void clearSession() {
        currentClient = null;
    }
}
