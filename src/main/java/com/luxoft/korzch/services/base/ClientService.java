package com.luxoft.korzch.services.base;

import com.luxoft.korzch.base.Common;
import com.luxoft.korzch.domain.Client;

import java.util.List;

public interface ClientService<T extends Client> extends Common<T> {

    /**
     * TODO add documentation
     */
    List<T> getAllClients();

    boolean removeClient(long id);

    T getClient(long id);

    boolean updateClient(long id, String email, String age);

    boolean createClient(String name, String lastName, String phone);

    boolean removeProductFromBasket(long id);

    List<T> getBasket(long clientId);

    boolean addProductToBasket(long id);

    long createClient(T client);


//    boolean createClient(String name, String lastName, String phone);
//
//    /**
//     * TODO add documentation
//     * */
//    boolean removeClient(String id);
//
//    /**
//     * TODO add documentation
//     * */
//    boolean updateClient(String id, String email , String age);
//
//    /**
//     * TODO add documentation
//     *
//     * @param id*/
//    boolean removeProductFromBasket(long id);
//
//    /**
//     * TODO add documentation
//     * */
//    boolean addProductToBasket(String id);
//
//    /**
//     * TODO add documentation
//     *
//     * @param id*/
//    Client getClient(long id);
//
//    /**
//     * TODO add documentation
//     *
//     * @param clientId*/
//    List<Product> getBasket(long clientId);
//
//    /**
//     * TODO add documentation
//     * */
//    List<Client> getAllClients();
}
