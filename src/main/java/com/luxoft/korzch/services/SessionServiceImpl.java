package com.luxoft.korzch.services;

import com.luxoft.korzch.session.Session;

public class SessionServiceImpl implements SessionService {

    private final Session session;

    public SessionServiceImpl(Session session) {
        this.session = session;
    }
}
