package com.yelpfusion.yelpreviews.service;

import com.google.gson.Gson;
import com.yelpfusion.yelpreviews.dao.ReviewsDAO;
import com.yelpfusion.yelpreviews.dto.Review;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;

@Service
public class YelpService {
    @Autowired
    ReviewsDAO dao;

    RestTemplate restTemplate = new RestTemplate();

    /*
     * Creates list of reviews to be stored in ReviewsDAO from the JSON response returned by
     * the Yelp API review page call.
     *
     * @param response The JSON response with review data retrieved from calling the business review page.
     * @return the reviews as a JSON string.
     */
    public String createReviews(ResponseEntity<String> response) {
        JSONArray reviews = new JSONObject(response.getBody()).getJSONArray("reviews");

        Iterator<Object> iterator = reviews.iterator();
        while(iterator.hasNext()) {

            String currStr = iterator.next().toString();

            // Map each JSON object to a review object.
            Review review = new Gson().fromJson(currStr,Review.class);
            review.setStrRepresentation(currStr);

            dao.addReview(review);
        }
        return reviews.toString();
    }

    // Gets the list of reviews.
    public List<Review> getReviews() {
        return dao.getReviews();
    }

    /*
     *  Creates a new HTTPEntity request with authorization header assigned to api key.
     *  Note: Additional header needed in order to do Yelp API calls.
     *  Then, makes a GET request to business review page and received response as JSON.
     *
     *  @param apiKey api key to create Yelp Api calls.
     *  @param url The business review page.
     *  @return The JSON response after making a request to the url.
     */
    public ResponseEntity<String> createRequestWithAuthHeader(String apiKey, String url) {
        HttpHeaders headers = new HttpHeaders();

        // Add header to restTemplate.
        headers.add("Authorization", "Bearer " + apiKey);

        // Create request.
        HttpEntity request = new HttpEntity(headers);

        // Make a GET request and retrieve JSON response.
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response;
    }

}
