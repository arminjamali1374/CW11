package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.model.Shipping;
import org.example.repository.ShippingRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShippingRepoImpl extends BaseRepositoryImpl<Integer, Shipping> implements ShippingRepo {

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getColumnsName() {
        return null;
    }

    @Override
    public String getUpdateQueryParams() {
        return null;
    }

    @Override
    public String getCountOfQuestionMarkForParams() {
        return null;
    }

    @Override
    public Shipping mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void fillParamForStatement(PreparedStatement preparedStatement, Shipping entity) throws SQLException {

    }

    @Override
    public void fillParamForStatementForUpdate(PreparedStatement preparedStatement, Shipping entity) throws SQLException {

    }
}
