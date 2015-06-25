package be.infosupport.java.spring.example.customer.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Path("/customers")
public class CustomersResource {
    private static List<Customer> customers;
    static {
        customers = new ArrayList<Customer>();
        addCustomer("Me", 31);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public List<Customer> customers() {
        return customers;
    }


    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response getCustomer(@PathParam("id") int id) {
        for(Customer customer : customers) {
            if (id == customer.getId()) {
                return Response.ok(customer).build();
            }
        }
        return Response.status(404).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public Response addCustomer(Customer customer) throws URISyntaxException {
        return Response.created(new URI("/customers/" + addCustomer(customer.getName(), customer.getAge()))).build();
    }


    private static int addCustomer(String name, int age) {
        Customer customer = new Customer(customers.size(), name, age);
        customers.add(customer);
        return customer.getId();
    }
}
