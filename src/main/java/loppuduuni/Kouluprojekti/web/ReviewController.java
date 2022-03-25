package loppuduuni.Kouluprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import loppuduuni.Kouluprojekti.domain.CategoryRepository;
import loppuduuni.Kouluprojekti.domain.Review;
import loppuduuni.Kouluprojekti.domain.ReviewRepository;



@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value= {"/", "/reviewlist"})
	public String reviewList(Model model) {
		model.addAttribute("reviews", reviewRepository.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
	return "reviewlist";
	}
	
    @RequestMapping(value = "/newReview")
    public String addReview(Model model){
    	model.addAttribute("review", new Review());
    	model.addAttribute("categories", categoryRepository.findAll());
        return "newReview";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Review review) {
		reviewRepository.save(review);
		return "redirect:/reviewlist";
	}
	
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteReview(@PathVariable("id") Long ReviewId, Model model) {
		reviewRepository.deleteById(ReviewId);
		return "redirect:/reviewlist";
	}
	
    @RequestMapping(value = "/editReview/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editReview(@PathVariable("id") Long ReviewId, Model model) {
    	model.addAttribute("review", reviewRepository.findById(ReviewId));
    	model.addAttribute("categories", categoryRepository.findAll());
    	return "editReview";
    }
}

