package tacos.dao;

import org.springframework.data.repository.CrudRepository;
import tacos.dao.Order;

public interface OrderRepository
        extends CrudRepository<Order, Long> { }
