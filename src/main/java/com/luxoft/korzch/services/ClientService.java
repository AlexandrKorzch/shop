package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface ClientService {

    /**
     * TODO add documentation
     * */
    boolean createClient(String name, String lastName, String phone);

    /**
     * TODO add documentation
     * */
    boolean removeClient(String id);

    /**
     * TODO add documentation
     * */
    boolean updateClient(String id, String email , String age);

    /**
     * TODO add documentation
     *
     * @param id*/
    boolean removeProductFromBasket(long id);

    /**
     * TODO add documentation
     * */
    boolean addProductToBasket(String id);

    /**
     * TODO add documentation
     *
     * @param id*/
    Client getClient(long id);

    /**
     * TODO add documentation
     *
     * @param clientId*/
    List<Product> getBasket(long clientId);

    /**
     * TODO add documentation
     * */
    List<Client> getAllClients();
}
