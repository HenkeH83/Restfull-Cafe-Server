package com.cafe;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cafe.beans.CoffeeBean;
import com.cafe.entitys.CoffeeEntity;
import com.cafe.models.CoffeeModel;

/**
 * Root resource (exposed at "cafeserver" path)
 */
@Path("cafeserver")
@SessionScoped
public class CafeServerEndPoint implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	CoffeeModel coffee; 
	
    @GET
    @Path("/coffees")
    @Produces(MediaType.APPLICATION_XML)
    public List<CoffeeBean> getAll() {
    	List<CoffeeBean> coffees = coffee.getEveryCoffee();
    	return coffees;
    }
    
    @GET
    @Path("/coffee/{coffeename}")
    @Produces(MediaType.APPLICATION_XML)
    public CoffeeBean getCoffee(@PathParam("coffeename")String name) {
    	return coffee.getCoffee(name);
    }
    
//    @PUT
//    @Path("/{coffeename}/{coffeeprice}")
//    @Consumes(MediaType.TEXT_PLAIN)
//    public void createCoffee(@PathParam("coffeename") String name,@PathParam("coffeeprice") long price) {
//    	coffee.createCoffee(name, price);
//    }
    

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_XML)
    public CoffeeBean createCoffee(CoffeeBean bean) {
        return coffee.createCoffee(bean);
    }
    
    @DELETE
    @Path("/delete/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public void deleteCoffee(@PathParam ("name")String name) {
    	coffee.deleteCoffee(name);
    }
}
