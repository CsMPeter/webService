package org.fasttrackit.webservice.persistance;

import org.fasttrackit.webservice.domain.WebItem;
import org.fasttrackit.webservice.transfer.CreateWebItemRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WebItemRepository {

    public void createWebItem(CreateWebItemRequest request) throws SQLException, IOException, ClassNotFoundException {

        String sql = "INSERT INTO web_item (last_name, first_name, phone_number) VALUES (?,?,?)";

        try (Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,request.getLastName());
            preparedStatement.setString(2,request.getFirstName());
            preparedStatement.setString(3,request.getPhoneNumber());

            preparedStatement.executeUpdate();
        }



    }

    public void updateWebItem(long id, String lastName,String firstName, String phoneNumber) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE web_item SET last_name=?, first_name=?, phone_number=? WHERE id=?";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,lastName);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,phoneNumber);
            preparedStatement.setLong(4,id);

            preparedStatement.executeUpdate();
        }
    }

    public void deleteWebItem(long id) throws SQLException, IOException, ClassNotFoundException {

        String sql = "DELETE FROM web_item WHERE id=?";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();
        }
    }

    public List<WebItem> getWebItems() throws SQLException, IOException, ClassNotFoundException {

        String sql = "SELECT id, last_name, first_name, phone_number FROM web_item";

        List<WebItem> webItems = new ArrayList<>();

        try(
                Connection connection = DatabaseConfiguration.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
                ){
            while(resultSet.next()){
                WebItem webItem = new WebItem();
                webItem.setId(resultSet.getLong("id"));
                webItem.setFirstName(resultSet.getString("first_name"));
                webItem.setLastName(resultSet.getString("last_name"));
                webItem.setPhoneNumber(resultSet.getString("phone_number"));

                webItems.add(webItem);
            }
        }
        return webItems;
    }

}
