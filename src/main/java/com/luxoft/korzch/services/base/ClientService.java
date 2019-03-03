package com.luxoft.korzch.services.base;

import com.luxoft.korzch.base.Common;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;

import java.util.List;

public interface ClientService<T extends Client> extends Common<T> {

    /**
     * TODO add documentation
     */
    void removeProductFromBasket(long id);


    /**
     * TODO add documentation
     */
    void update(long id, String email, int age);


    /**
     * TODO add documentation
     */
    void addProductToBasket(long id);


    /**
     * TODO add documentation
     */
    List<Product> getBasket();
}
