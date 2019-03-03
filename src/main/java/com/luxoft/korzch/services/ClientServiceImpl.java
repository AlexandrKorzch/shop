package com.luxoft.korzch.services;

import com.luxoft.korzch.database.dao.base.BasketDao;
import com.luxoft.korzch.database.dao.base.ClientDao;
import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Basket;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.base.ClientService;

import java.util.List;

public class ClientServiceImpl<T extends Client> implements ClientService<T> {

    private final ClientDao<Client> clientDao;
    private final BasketDao<Basket> basketDao;
    private final OrderDao<Order> orderDao;
    private ProductDao<Product> productDao;

    public ClientServiceImpl(ClientDao<Client> clientDao,
                             ProductDao<Product> productDao,
                             BasketDao<Basket> basketDao,
                             OrderDao<Order> orderDao) {

        this.clientDao = clientDao;
        this.productDao = productDao;
        this.basketDao = basketDao;
        this.orderDao = orderDao;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T get(long id) {
        return null;
    }


    @Override
    public void update(T item) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void create(T item) {

    }

    @Override
    public void removeProductFromBasket(long id) {

    }

    @Override
    public void update(long id, String email, int age) {

    }

    @Override
    public void addProductToBasket(long id) {

    }

    @Override
    public List<Product> getBasket() {
        return null;
    }

    //    @Override
//    public long create(T client) {
//        try {
//            ValidationService.validatePhone(client.getPhone());
////            ValidationService.validatePhoneNotExist(dao.getAll(), client.getPhone());
////            return super.create(client);
//        } catch (WrongPhoneException e) {
//            e.printStackTrace();
//            return FAIL;
//        }
//    }

//    @Override
//    public boolean update(long id, String email, int age) {
//        try {
//            ValidationService.validateAge(age);
//            ValidationService.validateEmail(email);
//            T client = dao.get(id);
//            client.setEmail(email);
//            client.setAge(age);
//            return super.update(client);
//        } catch (NotAllowedAgeException | WrongEmailException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public boolean addProductToBasket(long id) {
//        Client client = sessionService.getCurrentClient();
//        Basket basket = client.getBasket();
//        Product product = productDao.get(id);
//        basket.getItems().add(product);
//        return true;
//    }
//
//
//    @Override
//    public List<Product> getBasket() {
//        Client client = sessionService.getCurrentClient();
//        Basket basket = client.getBasket();
//        return basket.getItems();
//    }
//
//    @Override
//    public boolean removeProductFromBasket(long productId) {
//        Client client = sessionService.getCurrentClient();
//        Basket basket = client.getBasket();
//        for (Product product : basket.getItems()) {
//            if (product.getId() == productId) {
//                basket.getItems().remove(product);
//                return true;
//            }
//        }
//        return false;
//    }


}
