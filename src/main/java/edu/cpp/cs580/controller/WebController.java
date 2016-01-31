package edu.cpp.cs580.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

import edu.cpp.cs580.App;
import edu.cpp.cs580.data.User;
import edu.cpp.cs580.data.provider.UserManager;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
	@Autowired
	private UserManager userManager;	

	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs580/ping
	 */
	
	@RequestMapping(value = "/cs580/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}

	/**
	 * This is a simple example of how to use a data manager
	 * to retrieve the data and return it as an HTTP response.
	 *
	 * <p>
	 * Note, when it returns from the Spring, it will be
	 * automatically converted to JSON format.
	 * <p>
	 * Try it in your web browser:
	 * 	http://localhost:8080/cs580/user/user101
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.GET)
	User getUser(@PathVariable("userId") String userId) {
		User user = userManager.getUser(userId);
		return user;
	}

	/**
	 * This is an example of sending an HTTP POST request to
	 * update a user's information (or create the user if not
	 * exists before).
	 *
	 * You can test this with a HTTP client by sending
	 *  http://localhost:8080/cs580/user/user101
	 *  	name=John major=CS
	 *
	 * Note, the URL will not work directly in browser, because
	 * it is not a GET request. You need to use a tool such as
	 * curl.
	 *
	 * @param id
	 * @param name
	 * @param major
	 * @return
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.POST)
	User updateUser(
			@PathVariable("userId") String id,
			@RequestParam("name") String name,
			@RequestParam(value = "major", required = false) String major) {
		User user = new User();
		user.setId(id);
		user.setMajor(major);
		user.setName(name);
		userManager.updateUser(user);
		return user;
	}

	/**
	 * This API deletes the user. It uses HTTP DELETE method.
	 *
	 * @param userId
	 */
	@RequestMapping(value = "/cs580/user/{userId}", method = RequestMethod.DELETE)
	void deleteUser(
			@PathVariable("userId") String userId) {
		userManager.deleteUser(userId);
	}

	/**
	 * This API lists all the users in the current database.
	 *
	 * @return
	 */
	@RequestMapping(value = "/cs580/users/list", method = RequestMethod.GET)
	List<User> listAllUsers() {
		return userManager.listAllUsers();
	}

	/*********** Web UI Test Utility **********/
	/**
	 * This method provide a simple web UI for you to test the different
	 * functionalities used in this web service.
	 */
	@RequestMapping(value = "/cs580/home", method = RequestMethod.GET)
	ModelAndView getUserHomepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("users", listAllUsers());
		return modelAndView;
	}
	
	/** Assignment 3 */

	/**
	 * New example for HTTP API (hgdoan).
	 * It returns a String "Huy Doan: " & message from url in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs580/example/{msg}
	 */
	@RequestMapping(value = "/cs580/example/{msg}", method = RequestMethod.GET)
	String returnString(@PathVariable("msg") String msg) {
		return "Huy Doan: " + msg;
	}
	
	@RequestMapping(value = "/cs580/exampleGoogleLibrary", method = RequestMethod.GET)
	String returnLocation() {
		// Replace the API key below with a valid API key.
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCeBLuD_-XioM3h7wPmqsz6Vwp9Xsj1lLw");
		GeocodingResult[] results;
		try {
			results = GeocodingApi.geocode(context, 
					"3801 West Temple Avenue Pomona, California 91768").await();
			return "The address: " + results[0].formattedAddress + " have: <br>" +
					"Latitude: " + Double.toString(results[0].geometry.location.lat) + "<br>" +
					"Longtitude: " + Double.toString(results[0].geometry.location.lng) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** New example for HTTP API (darvesh).*/
	@RequestMapping (value = "/cs580/darvesh", method =RequestMethod.GET)
	String Darvesh(){
			return"Darvesh Pari Singh";
<<<<<<< HEAD
			
	
	
	}	
	public class MathLibraryExample {

		  public void main(String[] args) {
		    
		    int i = -7;
		    int j = -9;
		    
		  
		    System.out.println("i is " + i);     
		    System.out.println("j is " + j);
		   
		     
		    // The absolute value of a number is equal to 
		    // the number if the number is positive or 
		    // zero and equal to the negative of the number 
		    // if the number is negative.
		 
		    System.out.println("|" + i + "| is " + Math.abs(i));     
		    System.out.println("|" + j + "| is " + Math.abs(j));
		    ;

		    // Truncating and Rounding functions
		 
		   
		    // The "ceiling" of a number is the   
		    // smallest integer greater than or equal to
		    // the number. Every integer is its own 
		    // ceiling.
		     System.out.println("The ceiling of " + i + " is " + Math.ceil(i));     
		     System.out.println("The ceiling of " + j + " is " + Math.ceil(j));
		    
		     // The "floor" of a number is the largest  
		     // integer less than or equal to the number.
		     // Every integer is its own floor.
		     System.out.println("The floor of " + i + " is " + Math.floor(i));     
		     System.out.println("The floor of " + j + " is " + Math.floor(j));
		   
		     // Comparison operators

		     // min() returns the smaller of the two arguments you pass it
		     System.out.println("min(" + i + "," + j + ") is " + Math.min(i,j));     
		   
		     // There's a corresponding max() method 
		     // that returns the larger of two numbers 
		     System.out.println("max(" + i + "," + j + ") is " + Math.max(i,j));     
		    
		    }

		       
		   

		  }

		}


=======
	}
	
	/** New example for HTTP API (devika).*/
	@RequestMapping (value = "/cs580/devika", method =RequestMethod.GET)
 	String Devika(){
 			return"Devika kakkar";
 	}
	public class Guava_demo 
	{
		   public void main(String args[]) 
		   {
		      Guava_demo Test = new Guava_demo();
		      
		      Integer x =  99;
		      Integer y =  new Integer(10);
		      
		      System.out.println(Test.sum(x,y));
		   }

		   public Integer sum(Integer x, Integer y)
		   {
		      return x + y;
		   }	
		}

}>>>>>>> origin/master
