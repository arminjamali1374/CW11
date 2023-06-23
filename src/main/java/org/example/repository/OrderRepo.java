package org.example.repository;

import org.example.base.repository.BaseRepository;
import org.example.model.Order;

import java.sql.SQLException;

public interface OrderRepo extends BaseRepository<Integer, Order> {
    Long UserTotalPrice(int id) throws SQLException;
    int NumberOff(int id) throws SQLException;
}
