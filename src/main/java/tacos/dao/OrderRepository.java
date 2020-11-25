package tacos.dao;

import tacos.dao.Order;

public interface OrderRepository {

  Order save(Order order);
  
}
