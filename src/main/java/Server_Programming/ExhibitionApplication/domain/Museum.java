package Server_Programming.ExhibitionApplication.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Museum {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long museumid;
	private String name, country, address;
	
	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "museum")
	private List<Exhibition> exhibitions;*/

	public Museum() {
		super();
	}

	public Museum(String name, String country, String address) {
		super();
		this.name = name;
		this.country = country;
		this.address = address;
	}

	public long getMuseumid() {
		return museumid;
	}

	public void setMuseumid(long museumid) {
		this.museumid = museumid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	/*
	public List<Exhibition> getExhibitions() {
		return exhibitions;
	}

	public void setExhibitions(List<Exhibition> exhibitions) {
		this.exhibitions = exhibitions;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Museum [museumid=" + museumid + ", name=" + name + ", country=" + country + ", address=" + address
				+ ", exhibitions=" + "]";
	}

}
