package com.techelevator.locations;

import com.techelevator.locations.model.Location;
import com.techelevator.locations.services.ConsoleService;
import com.techelevator.locations.services.LocationService;
import org.springframework.web.client.RestTemplate;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final LocationService locationService = new LocationService();


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                handleListLocations();
            } else if (menuSelection == 2) {
                handleShowLocationDetails();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
            }
        }
    }

   private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_BASE_URL = "http://localhost:3000/locations/";



    private void handleListLocations() {
        //Step Five: List all locations
//        Location [] locations =locationService.getAll();
//        consoleService.printLocations(locations);
    }
    public Location [] getAll(){
        return restTemplate.getForObject(API_BASE_URL,Location[].class);

    }
    private void handleShowLocationDetails() {
        //Step Six: Get location details
    }

}