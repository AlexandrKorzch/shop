package com.luxoft.korzch.dao;

import com.luxoft.korzch.domain.Client;

public interface ClientDao {
    boolean saveClient(Client client);
    boolean removeClient(Client client);
}
