package loppuduuni.Kouluprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import loppuduuni.Kouluprojekti.domain.Review;
import loppuduuni.Kouluprojekti.domain.ReviewRepository;



@RestController
public class RestReviewController {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@GetMapping("reviews")
	Iterable<Review> getAll() {
		return reviewRepository.findAll();
	}
	
	@PostMapping("reviews")
	Review newReview(@RequestBody Review newReview) {
		return reviewRepository.save(newReview);
	}
	
	@PutMapping("/reviews/{id}")
	Review replaceReview(@RequestBody Review newReview, @PathVariable Long id) {
		newReview.setId(id);
		return reviewRepository.save(newReview);
	}
	
	@DeleteMapping("/reviews/{id}")
	void deleteReview(@PathVariable Long id) {
		reviewRepository.deleteById(id);
	}
}
