package com.luxoft.korzch.session;

import java.io.IOException;

public interface LoggedIn {
    void isLoggedIn(String clientId) throws IOException;
}
