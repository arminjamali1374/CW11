package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.model.Fruit;
import org.example.model.enums.WeightUnit;
import org.example.repository.FruitRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FruitRepoImpl extends BaseRepositoryImpl<Integer, Fruit>
        implements FruitRepo {
    @Override
    public String getTableName() {
        return "fruit";
    }

    @Override
    public String getColumnsName() {
        return "(name, description, stock_rate, weight_unit, weight, current_price, previous_price)";
    }

    @Override
    public String getUpdateQueryParams() {
        return "(name = ?, description = ?, stock_rate = ?, weight_unit = ?, weight = ?, current_price = ?, previous_price = ?)";
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return "(?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public Fruit mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Fruit(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getBoolean(4),
                WeightUnit.valueOf(resultSet.getString(5)),
                resultSet.getDouble(6),
                resultSet.getLong(7),
                resultSet.getLong(8));
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Fruit entity) throws SQLException {
        preparedStatement.setString(1,entity.getName());
        preparedStatement.setString(2,entity.getDescription());
        preparedStatement.setBoolean(3,entity.isStock());
        preparedStatement.setString(4, String.valueOf(entity.getWeightUnit()));
        preparedStatement.setDouble(5,entity.getWeight());
        preparedStatement.setLong(6,entity.getCurrentPrice());
        preparedStatement.setLong(7,entity.getPreviousPrice());
    }

    @Override
    public void fillParamForStatementForUpdate(PreparedStatement preparedStatement, Fruit entity) throws SQLException {
       fillParamForStatement(preparedStatement,entity);
       preparedStatement.setInt(8,entity.getId());
    }
}
