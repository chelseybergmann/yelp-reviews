package com.yelpfusion.yelpreviews.controller;
import com.yelpfusion.yelpreviews.service.YelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class YelpReviewsController {
    @Value("${yelp.api.key}")
    private String apiKey;

    @Autowired
    private YelpService service;

    // Used as a default business id for getReviews
    private final String DEFAULT_ID = "grs-sandwich-shoppe-janesville";

    /*
     * Makes a Yelp API call to the reviews page with the passed in business id.  It then
     * takes the reviews returned (up to three), creates a Review object for each, puts
     * them into a list, then returns the data as JSON to the endpoint.
     *
     * @param id The business id passed into the url parameter.
     * @return A JSON string containing the reviews' data.
     */
    @GetMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getReviews(@RequestParam(defaultValue = DEFAULT_ID) String id) {
        String businessReviewsURL
                = "https://api.yelp.com/v3/businesses/" + id + "/reviews";

        // Create and make request to review page, and return response as JSON.
        ResponseEntity<String> reviewsResponse = service.createRequestWithAuthHeader(apiKey, businessReviewsURL);

        String reviews = service.createReviews(reviewsResponse);

        return reviews;
    }
}

