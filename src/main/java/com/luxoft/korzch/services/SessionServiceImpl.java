package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.session.Session;

import static com.luxoft.korzch.util.Util.isNotNull;
import static com.luxoft.korzch.util.Util.longToString;

public class SessionServiceImpl implements SessionService {

    private final Session session;
    private ClientService clientService;

    public SessionServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public String isClientLoggedIn() {
        Client currentClient = session.getCurrentClient();
        if (isNotNull(currentClient)) {
            return longToString(currentClient.getId());
        } else {
            return null;
        }
    }

    @Override
    public boolean loginClient(String id) {
        Client client = clientService.getClient(id);
        if (isNotNull(client)) {
            return session.setCurrentClient(client);
        }
        return false;
    }

    @Override
    public void logOut() {

    }

    @Override
    public boolean clearSession() {
        return session.clearSession();
    }

    @Override
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
