package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.services.base.ClientService;
import com.luxoft.korzch.services.base.SessionService;
import com.luxoft.korzch.session.Session;

import static com.luxoft.korzch.common.Constants.FAIL;
import static com.luxoft.korzch.util.Util.isNotNull;

public class SessionServiceImpl implements SessionService {

    private final Session<Client> session;
    private ClientService clientService;

    public SessionServiceImpl(Session<Client> session) {
        this.session = session;
    }

    @Override
    public boolean loginClient(long id) {
        Client client = (Client) clientService.get(id);
        if (isNotNull(client)) {
            return session.setCurrentClient(client);
        }
        return false;
    }

    @Override
    public long isClientLoggedIn() {
        Client currentClient = session.getCurrentClient();
        if (isNotNull(currentClient)) {
            return currentClient.getId();
        } else {
            return FAIL;
        }
    }

    @Override
    public void logOut() {
        session.clearSession();
    }

    @Override
    public Client getCurrentClient() {
        return session.getCurrentClient();
    }

    @Override
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
}
