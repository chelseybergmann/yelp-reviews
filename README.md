# yelp-reviews
<h2> Description </h2>
This program builds an API endpoint to /reviews.  This API endpoint takes in a business id URL parameter, retrieves its Yelp 
reviews as JSON, deserializes each review to a Review object, stores them into a list, and outputs the information as JSON.
<h2>Tools and Frameworks</h2>
Java, Spring Boot, Yelp API
<h2>Instructions</h2>
<table>
<ol>
  <li>Create a Yelp API account and use your API key in the application.properties file.</li>
  <li>Run the program and navigate to localhost:8080/reviews. The default parameter is a local business.</li>
  <li>If you want to use a different business, you can retrieve the id from its official Yelp page in its URL.</li>
  <li>Add the business id parameter to the URL by adding ?id={businessId}.</li>
  <li>Yelp API will return three reviews.  The data is a JSON response.</li>
</ol>
</table>
