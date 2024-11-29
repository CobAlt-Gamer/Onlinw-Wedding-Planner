package com.weddingplanner;

import com.weddingplanner.dao.ClientDAO;
import com.weddingplanner.model.Client;

public class App {
    public static void main(String[] args) {
        // Initialize DAO
        ClientDAO clientDAO = new ClientDAO();

        // Create a new Client
        Client client = new Client("Alice Smith", "alice@example.com", "9876543210");

        // Save the Client to the database
        clientDAO.saveClient(client);

        // Fetch and display all clients
        System.out.println("Clients in the database:");
        clientDAO.getAllClients().forEach(System.out::println);
    }
}
