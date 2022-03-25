package loppuduuni.Kouluprojekti.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
public interface ReviewRepository extends CrudRepository<Review, Long> {

	List<Review> findByNimi(String nimi);
	List<Review> findByNimiIgnoreCase(String nimi);
	
	
}
