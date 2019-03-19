package com.luxoft.korzch.services.jdbc;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.services.ClientService;
import com.luxoft.korzch.services.SessionService;
import com.luxoft.korzch.session.Session;

import static com.luxoft.korzch.util.Util.isNotNull;

public class SessionServiceImpl implements SessionService {

    private final Session<Client> session;
    private ClientService clientService;

    public SessionServiceImpl(Session<Client> session) {
        this.session = session;
    }

    @Override
    public void loginClient(long id) {
        Client client = (Client) clientService.get(id);
        session.setCurrentClient(client);
    }

    @Override
    public boolean isClientLoggedIn() {
        Client currentClient = session.getCurrentClient();
        return isNotNull(currentClient);
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
