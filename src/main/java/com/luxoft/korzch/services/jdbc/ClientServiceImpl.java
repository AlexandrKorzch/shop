package com.luxoft.korzch.services.jdbc;

import com.luxoft.korzch.database.dao.base.BasketDao;
import com.luxoft.korzch.database.dao.base.ClientDao;
import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;
import com.luxoft.korzch.services.ClientService;
import com.luxoft.korzch.services.SessionService;

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
    public boolean create(Client client) {
        return clientDao.create(client);
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
    public boolean update(Client client) {
        return clientDao.update(client);
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
}
