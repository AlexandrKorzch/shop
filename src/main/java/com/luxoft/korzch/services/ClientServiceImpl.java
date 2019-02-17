package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.base.ClientDao;
import com.luxoft.korzch.dao.base.ProductDao;
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

public class ClientServiceImpl<T extends Client> extends Service<T> implements ClientService<T> {

    private ClientDao<T> clientDao;
    private ProductDao<Product> productDao;
    private final SessionService sessionService;

    public ClientServiceImpl(SessionService sessionService,
                             ClientDao<T> clientDao,
                             ProductDao<Product> productDao) {
        setCommonDao(clientDao);
        this.clientDao = clientDao;
        this.productDao = productDao;
        this.sessionService = sessionService;
    }

    @Override
    public long createClient(T client) {
        try {
            ValidationService.validatePhone(client.getPhone());
            return dao.create(client);
        } catch (WrongPhoneException e) {
            e.printStackTrace();
            return FAIL;
        }
    }

    @Override
    public boolean updateClient(long id, String email, int age) {
        try {
            ValidationService.validateAge(age);
            ValidationService.validateEmail(email);
            T client = dao.get(id);
            client.setEmail(email);
            client.setAge(age);
            return update(client);
        } catch (UnrealAgeException | WrongEmailException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addProductToBasket(long id) {
        return false;
    }

    @Override
    public List<T> getAllClients() {
        return getAll();
    }

    @Override
    public boolean removeClient(long id) {
        return delete(id);
    }

    @Override
    public T getClient(long id) {
        return null;
    }


    @Override
    public boolean removeProductFromBasket(long id) {
        return false;
    }

    @Override
    public List<T> getBasket(long clientId) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }


    //    @Override
//    public List<Product> getBasket(long clientId) {
//        return null;
//    }
//
//        @Override
//    public boolean createClient(String name, String lastName, String phone) {
//        return clientDao.save(new Client(name, lastName, phone));
//    }
//
//    @Override
//    public boolean removeClient(String id) {
//        return clientDao.remove(idToLong(id));
//    }
//
//    @Override
//    public boolean updateClient(String clientId, String email, String age) {
//        return clientDao.update(idToLong(clientId), email, ageToInt(age));
//    }
//
//    @Override
//    public List<Client> getAllClients() {
//        return clientDao.getAll();
//    }
//
//    @Override
//    public boolean removeProductFromBasket(long productId) {
//        Client client = sessionService.getCurrentClient();
//        Basket basket = client.getItems();
//        basket.getItems().forEach(product1 -> {
//            if(product1.getId() == productId){
//                basket.getItems().remove(product1);
//            }
//        });
//        return false;
//    }
//
//    @Override
//    public boolean addProductToBasket(String productId) {
//        Client client = sessionService.getCurrentClient();
//        Basket basket = client.getItems();
//        Product product = productDao.getProduct(idToLong(productId));
//        basket.getItems().add(product);
//        return true;
//    }
//
//    @Override
//    public Client getClient(long id) {
//        return clientDao.get(id);
//    }
//
//    @Override
//    public List<Product> getItems(long clientId) {
//        Client client = sessionService.getCurrentClient();
//        Basket basket = client.getItems();
//        return basket.getItems();
//    }
}
