package loppuduuni.Kouluprojekti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import loppuduuni.Kouluprojekti.domain.Category;
import loppuduuni.Kouluprojekti.domain.CategoryRepository;
import loppuduuni.Kouluprojekti.domain.Review;
import loppuduuni.Kouluprojekti.domain.ReviewRepository;
import loppuduuni.Kouluprojekti.domain.User;
import loppuduuni.Kouluprojekti.domain.UserRepository;



@SpringBootApplication
public class KouluprojektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KouluprojektiApplication.class, args);
	}
	@Bean
	public CommandLineRunner reviewstore(ReviewRepository reviewRepo, CategoryRepository categoryRepo, UserRepository urepository) {
		return (args) -> {
			
			categoryRepo.save(new Category("Kokkasin"));
			categoryRepo.save(new Category("Söin"));

			
			reviewRepo.save(new Review("Pinaattiletut", "06.03.2022", "Pinaattia ja Lettuja", 5, 3, "Lettuja ja pinaattia mikroon 3 minuutiksi",
			categoryRepo.findByNimi("Kokkasin").get(0)));
			
			reviewRepo.save(new Review("Helppo munakas", "02.04.2022", "4 kananmunaa, 0,5 dl vetta tai kermaa, tomaatti, 100 g Snellmanin Ylikypsää kinkkua, suolaa, pippuria, voita paistamiseen", 5, 5, "Sekoita munat, neste ja mauste. Voitele pannu ja paista miedolla lämmöllä lisäten sekaan loput ainekset",
			categoryRepo.findByNimi("Kokkasin").get(0)));

			
			// Luo käyttäjät: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		
		System.out.println("Hae kaikki arvostelut tietokannasta");
			for (Review review : reviewRepo.findAll()) {
				System.out.println("Arvostelu: " + review.toString());
			}
		};
	}
}
