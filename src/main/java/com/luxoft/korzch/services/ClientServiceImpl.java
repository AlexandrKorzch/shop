package com.luxoft.korzch.services;

import com.luxoft.korzch.dao.ClientDao;
import com.luxoft.korzch.dao.ProductDao;
import com.luxoft.korzch.domain.Basket;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Product;

import java.util.List;

import static com.luxoft.korzch.util.Util.ageToInt;
import static com.luxoft.korzch.util.Util.idToLong;

public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private final ProductDao productDao;
    private final SessionService sessionService;

    public ClientServiceImpl(ProductDao productDao, ClientDao clientDao, SessionService sessionService) {
        this.clientDao = clientDao;
        this.productDao = productDao;
        this.sessionService = sessionService;
    }

    @Override
    public boolean createClient(String name, String lastName, String phone) {
        return clientDao.saveClient(new Client(name, lastName, phone));
    }

    @Override
    public boolean removeClient(String id) {
        return clientDao.removeClient(idToLong(id));
    }

    @Override
    public boolean updateClient(String clientId, String email, String age) {
        return clientDao.updateClient(idToLong(clientId), email, ageToInt(age));
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    @Override
    public boolean removeProductFromBasket(String productId) {
        Client client = sessionService.getCurrentClient();
        Basket basket = client.getBasket();
        basket.getBasket().forEach(product1 -> {
            if(product1.getId() == idToLong(productId)){
                basket.getBasket().remove(product1);
            }
        });
        return false;
    }

    @Override
    public boolean addProductToBasket(String productId) {
        Client client = sessionService.getCurrentClient();
        Basket basket = client.getBasket();
        Product product = productDao.getProduct(idToLong(productId));
        basket.getBasket().add(product);
        return true;
    }

    @Override
    public Client getClient(String clientId) {
        return clientDao.getClient(idToLong(clientId));
    }

    @Override
    public List<Product> getBasket(String clientId) {
        Client client = sessionService.getCurrentClient();
        Basket basket = client.getBasket();
        return basket.getBasket();
    }
}
