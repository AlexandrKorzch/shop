package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.services.base.ClientService;
import com.luxoft.korzch.services.base.SessionService;
import com.luxoft.korzch.session.Session;

import static com.luxoft.korzch.util.Util.isNotNull;

public class SessionServiceImpl implements SessionService {

    private final Session session;
    private ClientService clientService;

    public SessionServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public long isClientLoggedIn() {
        return 0;
    }

    @Override
    public boolean loginClient(long id) {
        return false;
    }

    @Override
    public void logOut() {

    }

    @Override
    public void setClientService(ClientService clientService) {

    }

    @Override
    public Client getCurrentClient() {
        return null;
    }

    //    @Override
//    public long isClientLoggedIn() {
//        Client currentClient = session.getCurrentClient();
//        if (isNotNull(currentClient)) {
//            return currentClient.getId();
//        } else {
//            return -1;
//        }
//    }
//
//    @Override
//    public boolean loginClient(long id) {
//        Client client = clientService.getClient(id);
//        if (isNotNull(client)) {
//            return session.setCurrentClient(client);
//        }
//        return false;
//    }
//
//    @Override
//    public void logOut() {
//        session.clearSession();
//    }
//
//    @Override
//    public Client getCurrentClient() {
//        return session.getCurrentClient();
//    }
//
//    @Override
//    public void setClientService(ClientService clientService) {
//        this.clientService = clientService;
//    }
}
