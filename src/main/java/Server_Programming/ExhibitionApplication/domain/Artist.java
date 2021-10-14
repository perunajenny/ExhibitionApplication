package Server_Programming.ExhibitionApplication.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artist {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long artistid;
	@NotNull
	@Size(min=2, max=100)
	private String name;
	@NotNull
	@Size(min=2, max=50)
	private String country;
	private int birthyear;
	
	@JsonIgnore 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "artist")
	private List<Exhibition> exhibitions;
	
	public Artist() {
		super();
	}

	public Artist(String name, String country, int birthyear) {
		super();
		this.name = name;
		this.country = country;
		this.birthyear = birthyear;
	}

	public long getArtistid() {
		return artistid;
	}

	public void setArtistid(long artistid) {
		this.artistid = artistid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}
	

	public List<Exhibition> getExhibitions() {
		return exhibitions;
	}

	public void setExhibitions(List<Exhibition> exhibitions) {
		this.exhibitions = exhibitions;
	}

	@Override
	public String toString() {
		return "Artist [artistid=" + artistid + ", name=" + name + ", country=" + country + ", birthyear=" + birthyear
				+ "]";
	}
	
}
