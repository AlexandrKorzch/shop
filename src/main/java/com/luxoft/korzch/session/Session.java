package com.luxoft.korzch.session;

import com.luxoft.korzch.domain.Client;

public class Session<T extends Client> {

    private T currentClient;

    public T getCurrentClient() {
        return currentClient;
    }

    public boolean setCurrentClient(T currentClient) {
        this.currentClient = currentClient;
        return true;
    }

    public boolean clearSession() {
        currentClient = null;
        return true;
    }
}
