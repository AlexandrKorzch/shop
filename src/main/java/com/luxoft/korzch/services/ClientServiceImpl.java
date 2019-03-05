package com.luxoft.korzch.services;

import com.luxoft.korzch.database.dao.base.BasketDao;
import com.luxoft.korzch.database.dao.base.ClientDao;
import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.base.ClientService;
import com.luxoft.korzch.services.base.SessionService;

import java.util.List;

public class ClientServiceImpl implements ClientService<Client> {

    private final ClientDao<Client> clientDao;
    private final BasketDao basketDao;
    private final OrderDao<Order> orderDao;
    private final ProductDao<Product> productDao;
    private final SessionService sessionService;

    public ClientServiceImpl(ClientDao<Client> clientDao,
                             ProductDao<Product> productDao,
                             BasketDao basketDao,
                             OrderDao<Order> orderDao,
                             SessionService sessionService) {

        this.clientDao = clientDao;
        this.productDao = productDao;
        this.basketDao = basketDao;
        this.orderDao = orderDao;
        this.sessionService = sessionService;
    }

    @Override
    public boolean create(Client item) {
        return clientDao.create(item);
    }

    @Override
    public Client get(long id) {
        return clientDao.get(id);
    }

    @Override
    public List<Client> getAll() {
        return clientDao.getAll();
    }

    @Override
    public boolean update(Client item) {
        return clientDao.update(item);
    }

    @Override
    public boolean delete(long id) {
        return clientDao.delete(id);
    }

    @Override
    public boolean update(long id, String email, int age) {
        return clientDao.update(new Client(id, email, age));
    }

    @Override
    public boolean addProductToBasket(long id) {
        return basketDao.add(id, sessionService.getCurrentClient().getId());
    }

    @Override
    public boolean removeProductFromBasket(long productId) {
        return basketDao.remove(productId, sessionService.getCurrentClient().getId());
    }

    @Override
    public List<Product> getBasket() {
        return basketDao.getAll(sessionService.getCurrentClient().getId());
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
