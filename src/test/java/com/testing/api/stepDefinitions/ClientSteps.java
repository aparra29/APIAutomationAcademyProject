package com.testing.api.stepDefinitions;

import com.testing.api.models.Client;
import com.testing.api.requests.ClientRequest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClientSteps {
    
    private static final Logger logger = LogManager.getLogger(ClientSteps.class);
    private final ClientRequest clientRequest = new ClientRequest();
    private Response response;
    private String oldNumber;
    private Client client;
    private Client originalClient;


    @Given("there are at least 10 registered clients in the system")
    public void thereAreAtLeast10RegisteredClientsInTheSystem(){
        response = clientRequest.getClients();
        logger.info(response.jsonPath().prettify());
        Assert.assertEquals(200, response.statusCode());
        List<Client> clientList = clientRequest.getClientsEntity(response);
        Assert.assertTrue("At least 10 clients should exist",clientList.size() >= 10);
    }
    //-------------------------------------------------------------------------------------------


    @When("I find the first client named Laura")
    public void findFirstLaura(){
        List<Client> clientList = clientRequest.getClientsEntity(response);

        originalClient = clientList.stream()
                .filter(client -> "Laura".equals(client.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No client named Laura found"));
    }

    @When("I save her current phone number")
    public void saveCurrentPhone(){
        Assert.assertNotNull("Original client should not be null", originalClient);
    }

    @When("I send a PUT request to update her phone number")
    public void updatePhone(){
        oldNumber = originalClient.getPhone();
        String newNumber = "098"+System.currentTimeMillis();
        originalClient.setPhone(newNumber);
        response = clientRequest.updateClient(originalClient,originalClient.getId());
    }

    @When("I create a new client")
    public void createClient(){
        response = clientRequest.createDefaultClient();
        logger.info(response.statusCode());
    }

    @When("I find the newly created client")
    public void findLastClient(){
        List<Client> clientList = clientRequest.getClientsEntity(response);

         clientList.stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There are no clients"));
    }

    @When("I send a PUT request to update the client")
    public void updateLastClient(String requestBody){
        List<Client> clientList = clientRequest.getClientsEntity(response);
        Client firstClient = clientList.stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There are no clients"));
        String firstId = firstClient.getId();
        client = clientRequest.getClientEntity(requestBody);
        response = clientRequest.updateClient(client, firstId);
    }

    @When("I send a DELETE request to delete the client")
    public void deleteLastClient(){
        List<Client> clientList = clientRequest.getClientsEntity(response);
        Client firstClient = clientList.stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There are no clients"));
        String firstId = firstClient.getId();
        response = clientRequest.deleteClient(firstId);
    }
    //------------------------------------------------------------------------


    @Then("I validate her phone number is different")
    public void validatePhoneNumberIsDifferent(){
        Assert.assertNotEquals("Phone number should be different",
                oldNumber, originalClient.getPhone());
    }

    @Then("the response should have a status code of {int}")
    public void theResponseShouldHaveAStatusCodeOf(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }

}
