package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.session.Session;

public class SessionServiceImpl implements SessionService {

    private final Session session;

    public SessionServiceImpl(Session session) {
        this.session = session;
    }

    @Override
    public void setCurrentClient(Client client) {
        session.setCurrentClient(client);
    }
}
