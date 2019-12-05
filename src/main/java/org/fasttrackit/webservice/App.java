package org.fasttrackit.webservice;

import org.fasttrackit.webservice.persistance.WebItemRepository;
import org.fasttrackit.webservice.transfer.CreateWebItemRequest;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        CreateWebItemRequest request = new CreateWebItemRequest();
        request.setFirstName("James");
        request.setLastName("Bond");
        request.setPhoneNumber("0787511439");
        WebItemRepository repository = new WebItemRepository();
        //repository.createWebItem(request);
        //repository.updateWebItem(1,"Jack","Sparrow","0823213238");
        repository.getWebItems();


    }
}
