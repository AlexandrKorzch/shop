package com.luxoft.korzch.services.base;

import com.luxoft.korzch.base.Common;
import com.luxoft.korzch.domain.Client;

import java.util.List;

public interface ClientService<T extends Client> extends Common<T> {

    /**
     * TODO add documentation
     */
    boolean removeClient(long id);

    /**
     * TODO add documentation
     */
    boolean updateClient(long id, String email, int age);

    /**
     * TODO add documentation
     */
    boolean removeProductFromBasket(long id);

    /**
     * TODO add documentation
     */
    boolean addProductToBasket(long id);

    /**
     * TODO add documentation
     */
    long createClient(T client);

    /**
     * TODO add documentation
     */
    T getClient(long id);

    /**
     * TODO add documentation
     */
    List<T> getBasket(long clientId);

    /**
     * TODO add documentation
     */
    List<T> getAllClients();
}
