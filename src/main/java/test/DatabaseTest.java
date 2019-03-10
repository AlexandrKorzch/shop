package test;

import com.luxoft.korzch.database.DBConnectionProvider;
import com.luxoft.korzch.database.dao.BasketDaoImpl;
import com.luxoft.korzch.database.dao.ClientDaoImpl;
import com.luxoft.korzch.database.dao.OrderDaoImpl;
import com.luxoft.korzch.database.dao.ProductDaoImpl;
import com.luxoft.korzch.database.dao.base.BasketDao;
import com.luxoft.korzch.database.dao.base.ClientDao;
import com.luxoft.korzch.database.dao.base.OrderDao;
import com.luxoft.korzch.database.dao.base.ProductDao;
import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.domain.Order;
import com.luxoft.korzch.domain.Product;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class DatabaseTest {

    private static DBConnectionProvider database;
    private static ClientDao<Client> clientDao;
    private static ProductDao<Product> productDao;
    private static BasketDao basketDao;
    private static OrderDao<Order> orderDao;

    @BeforeClass
    public static void setUp() {
        database = new DBConnectionProvider();
        productDao = new ProductDaoImpl(database.getConnection());
        clientDao = new ClientDaoImpl(database.getConnection());
        basketDao = new BasketDaoImpl(database.getConnection());
        orderDao = new OrderDaoImpl(database.getConnection());
    }

    @Test
    public void create() {
        //create client
        Client client = new Client("Ivan", "Ivanov", "+380973777458");
        assertTrue(clientDao.create(client));

        //update client | getAll
        client = clientDao.getAll().stream().reduce((first, second) -> second).orElse(null);
        long clientId = client.getId();
        String clientName = client.getName();
        String clientLastName = client.getLastName();
        String clientPhone = client.getPhone();
        client.setEmail("ivanov@gmail.com");
        client.setAge(30);
        assertTrue(clientDao.update(client));

        //get client
        client = clientDao.get(clientId);
        assertEquals(clientId, client.getId());
        assertEquals("ivanov@gmail.com", client.getEmail());
        assertEquals(30, client.getAge());
        assertEquals(clientName, client.getName());
        assertEquals(clientLastName, client.getLastName());
        assertEquals(clientPhone, client.getPhone());

        //add product
        Product product = new Product("Apple", 25.56);
        assertTrue(productDao.create(product));

        //get product
        long productId = productDao.getAll().stream().reduce((first, second) -> second).orElse(null).getId();
        product = productDao.get(productId);
        assertEquals("Apple", product.getName());
        assertEquals(25.56, product.getPrice(), 0);

        //update product
        product.setPrice(28.65);
        assertTrue(productDao.update(product));
        product = productDao.get(productId);
        assertEquals(28.65, product.getPrice(), 0);

        //basket
        assertTrue(basketDao.add(productId, clientId));
        product = basketDao.getAll(clientId).stream().reduce((first, second) -> second).orElse(null);
        assertEquals("Apple", product.getName());
        assertEquals(28.65, product.getPrice(), 0);

        //order
        Order order = new Order();
        order.setClientId(clientId);
        order.setProducts(basketDao.getAll(clientId));
        assertTrue(orderDao.create(order));

        //get last client order
        order = orderDao.getAllClientOrders(clientId).stream().reduce((first, second) -> second).orElse(null);
        assertEquals(clientId, order.getClientId());
        assertEquals(basketDao.getAll(clientId).size(), order.getProducts().size());
    }

    @AfterClass
    public static void tearDown() {
        database = null;
        clientDao = null;
    }
}