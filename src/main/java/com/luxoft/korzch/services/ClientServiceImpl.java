package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.base.ClientDao;
import com.luxoft.korzch.dao.base.ProductDao;
import com.luxoft.korzch.domain.Basket;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.exceptions.UnrealAgeException;
import com.luxoft.korzch.exceptions.WrongEmailException;
import com.luxoft.korzch.exceptions.WrongPhoneException;
import com.luxoft.korzch.services.base.ClientService;
import com.luxoft.korzch.services.base.Service;
import com.luxoft.korzch.services.base.SessionService;
import com.luxoft.korzch.valivator.ValidationService;

import java.util.List;

import static com.luxoft.korzch.common.Constants.FAIL;

public class ClientServiceImpl<T extends Client>
        extends Service<ClientDao<T>, T>
        implements ClientService<T> {

    private ProductDao<Product> productDao;
    private final SessionService sessionService;

    public ClientServiceImpl(SessionService sessionService,
                             ClientDao<T> clientDao,
                             ProductDao<Product> productDao) {
        dao = clientDao;
        this.productDao = productDao;
        this.sessionService = sessionService;
    }

    @Override
    public long create(T client) {
        try {
            ValidationService.validatePhone(client.getPhone());
            return super.create(client);
        } catch (WrongPhoneException e) {
            e.printStackTrace();
            return FAIL;
        }
    }

    @Override
    public boolean update(long id, String email, int age) {
        try {
            ValidationService.validateAge(age);
            ValidationService.validateEmail(email);
            T client = dao.get(id);
            client.setEmail(email);
            client.setAge(age);
            return super.update(client);
        } catch (UnrealAgeException | WrongEmailException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addProductToBasket(long id) {
        Client client = sessionService.getCurrentClient();
        Basket basket = client.getBasket();
        Product product = productDao.get(id);
        basket.getItems().add(product);
        return true;
    }


    @Override
    public List<Product> getBasket(long clientId) {
        Client client = sessionService.getCurrentClient();
        Basket basket = client.getBasket();
        return basket.getItems();
    }

    @Override
    public boolean removeProductFromBasket(long productId) {
        Client client = sessionService.getCurrentClient();
        Basket basket = client.getBasket();
        for (Product product : basket.getItems()) {
            if (product.getId() == productId) {
                basket.getItems().remove(product);
                return true;
            }
        }
        return false;
    }
}
