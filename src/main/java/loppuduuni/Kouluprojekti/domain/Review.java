package loppuduuni.Kouluprojekti.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.persistence.Id;




@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=2, max=100)
	private String nimi;
	
	@Size(min=1, max=10)
	private	String pvm;
	
	@Size(min=1)	
	private String aineet;
	
	@Size(min=1)
	private String resepti;
	
	private int aika;
	@Min(0)
	@Max(5)
	private int arvio;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Review() {
		super();
	}
	
	public Review(String nimi,String pvm, String aineet, int aika, int arvio, String resepti, Category category) {
		
		super();
		this.nimi= nimi;
		this.pvm= pvm;
		this.aineet= aineet;
		this.aika= aika;
		this.arvio= arvio;
		this.resepti= resepti;
		this.category= category;
	}
	
	public Review(String nimi, String pvm, String aineet) {
		
		super();
		this.nimi= nimi;
		this.pvm= pvm;
		this.aineet= aineet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
		this.pvm = pvm;
	}

	public String getAineet() {
		return aineet;
	}

	public void setAineet(String aineet) {
		this.aineet = aineet;
	}

	public String getResepti() {
		return resepti;
	}

	public void setResepti(String resepti) {
		this.resepti = resepti;
	}

	public int getAika() {
		return aika;
	}

	public void setAika(int aika) {
		this.aika = aika;
	}

	public int getArvio() {
		return arvio;
	}

	public void setArvio(int arvio) {
		this.arvio = arvio;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", nimi=" + nimi + ", pvm=" + pvm + ", aineet=" + aineet + ", resepti=" + resepti
				+ ", aika=" + aika + ", arvio=" + arvio + ", category=" + this.getCategory() + "]";
	}
	
}
