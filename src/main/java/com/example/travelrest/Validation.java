package com.example.travelrest;

import model.Agent;
import model.Customer;

public class Validation {
    public static boolean isValidCustomer(Customer customer) {
        boolean isValid = true;
        if (customer.getCustFirstName().equals("") && customer.getCustLastName().equals("")
                && customer.getCustAddress().equals("") && customer.getCustCity().equals("")
                && customer.getCustProv().equals("") && customer.getCustPostal().equals("")
                && customer.getCustCountry().equals("") && customer.getCustHomePhone().equals("")
                && customer.getCustBusPhone().equals("") && customer.getCustEmail().equals("")) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidAgent(Agent agent) {
        boolean isValid = true;
        if (agent.getAgtFirstName().equals("") && agent.getAgtLastName().equals("")
                && agent.getAgtBusPhone().equals("") && agent.getAgtEmail().equals("")
                && agent.getAgtPosition().equals("")) {
            isValid = false;
        }
        return isValid;
    }
}
