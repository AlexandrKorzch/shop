package com.luxoft.korzch.services;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface ClientService {

    /**
     * todo add documentation
     * */
    boolean createClient(String name, String lastName, String phone);

    /**
     * todo add documentation
     * */
    boolean removeClient(String id);

    /**
     * todo add documentation
     * */
    boolean updateClient(String id, String email , String age);

    /**
     * todo add documentation
     * */
    boolean removeProductFromBasket(String id);

    /**
     * todo add documentation
     * */
    boolean addProductToBasket(String id);

    /**
     * todo add documentation
     * */
    Client getClient(String id);

    /**
     * todo add documentation
     * */
    List<Product> getBasket(String clientId);

    /**
     * todo add documentation
     * */
    List<Client> getAllClients();
}
