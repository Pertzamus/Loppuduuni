package loppuduuni.Kouluprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long categoryid;
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnore
	private List<Review> reviews;
	
	public Category() {}
	
	public Category(String nimi) {
		super();
		this.nimi = nimi;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", nimi=" + nimi + "]";
	}


}
