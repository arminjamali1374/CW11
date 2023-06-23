package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.connection.DBConnection;
import org.example.model.Order;
import org.example.repository.OrderRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepoImpl extends BaseRepositoryImpl<Integer, Order> implements OrderRepo {

    @Override
    public String getTableName() {
        return "order";
    }

    @Override
    public String getColumnsName() {
       return "(user_id,state,shipping_id)";
    }

    @Override
    public String getUpdateQueryParams() {
       return "(user_id=?,state=?,shipping_id=?)";
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return "(?,?,?)";
    }

    @Override
    public Order mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Order(resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getBoolean(3),
                resultSet.getInt(4),
                resultSet.getLong(5));
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Order entity) throws SQLException {
        preparedStatement.setInt(1,entity.getId());
        preparedStatement.setBoolean(2,entity.isStatus());
        preparedStatement.setInt(3,entity.getShippingID());
        preparedStatement.setLong(4,entity.getPaycheck());
    }

    @Override
    public void fillParamForStatementForUpdate(PreparedStatement preparedStatement, Order entity) throws SQLException {
        fillParamForStatement(preparedStatement,entity);
        preparedStatement.setInt(5,entity.getId());
    }

    @Override
    public Long UserTotalPrice(int id) throws SQLException {
       String sql=" select sum(paycheck) from \"order\" where user_id=?";
       try (PreparedStatement preparedStatement= DBConnection.getConnection().prepareStatement(sql)){
           preparedStatement.setInt(1,id);
           ResultSet resultSet=preparedStatement.executeQuery();
          if (resultSet.next())
              return resultSet.getLong(1);

       }
       return -1L ;
    }

    @Override
    public int NumberOff(int id) throws SQLException {
        String sql=" select count(shipping_id) from \"order\" where user_id=?";
        try (PreparedStatement preparedStatement= DBConnection.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);

        }
        return -1 ;
    }
}
