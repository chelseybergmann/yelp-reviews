import com.yelpfusion.yelpreviews.controller.YelpReviewsController;
import com.yelpfusion.yelpreviews.dao.ReviewsDAO;
import com.yelpfusion.yelpreviews.service.YelpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class YelpReviewsApplicationTests {
	@Autowired
	private YelpReviewsController controller;
	@Autowired
	private ReviewsDAO dao;
	@Autowired
	private YelpService service;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(dao).isNotNull();
		assertThat(service).isNotNull();
	}

}
