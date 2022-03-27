package loppuduuni.Kouluprojekti;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import loppuduuni.Kouluprojekti.domain.Review;
import loppuduuni.Kouluprojekti.domain.ReviewRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {

	@Autowired 
	ReviewRepository reviewRepository;
	
	@Test
	public void findByNimiShouldReturnNimi() {
		List<Review> reviews = reviewRepository.findByNimi("Pinaattiletut");
		assertThat(reviews.get(0).getNimi()).isEqualTo("Pinaattiletut");
	}
	
	@Test
	public void findByNimiShouldReturnSize() {
		List<Review> reviews = reviewRepository.findByNimi("Pinaattiletut");
		assertThat(reviews).hasSize(1);
		
	}
	
	@Test
	public void findByNimiShouldReturnPvm() {
		List<Review> reviews = reviewRepository.findByNimi("Pinaattiletut");
		assertThat(reviews.get(0).getPvm()).isEqualTo("06.03.2022");
	}
		
	
	@Test 
	public void insertNewReview() {
		//public Review(String nimi, String pvm, String aineet) 
		Review review = new Review("Veriletut", "12.12.2020", "Verta, lettuja");
		reviewRepository.save(review);
		assertThat(review.getId()).isNotNull();
	}

}