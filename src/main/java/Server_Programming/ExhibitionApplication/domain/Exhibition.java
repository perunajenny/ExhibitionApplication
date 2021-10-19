package Server_Programming.ExhibitionApplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Exhibition {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long exhibitionid;
	@NotNull
	@Size(min=1, max=200)
	private String name;
	@NotNull
	@Size(min=8, max=21)
	private String time;
	
	  @ManyToOne
	  @JsonIgnore 
	    @JoinColumn(name = "artistid")
	    private Artist artist;
	  
	    @ManyToOne
	    @JsonIgnore 
	    @JoinColumn(name = "museumid")
	    private Museum museum;


		public Exhibition() {
			super();
		}
		
		

		public Exhibition(@NotNull @Size(min = 1, max = 200) String name, @NotNull @Size(min = 8, max = 21) String time,
				Artist artist, Museum museum) {
			super();
			this.name = name;
			this.time = time;
			this.artist = artist;
			this.museum = museum;
		}



		public Exhibition(String name, String time, Artist artist) {
			super();
			this.name = name;
			this.time = time;
			this.artist = artist;
		}

		public long getExhibitionid() {
			return exhibitionid;
		}

		public void setExhibitionid(long exhibitionid) {
			this.exhibitionid = exhibitionid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Artist getArtist() {
			return artist;
		}

		public void setArtist(Artist artist) {
			this.artist = artist;
		}
		
		
		
		public Museum getMuseum() {
			return museum;
		}

		public void setMuseum(Museum museum) {
			this.museum = museum;
		}
		

		public String getTime() {
			return time;
		}



		public void setTime(String time) {
			this.time = time;
		}



		@Override
		public String toString() {
			return "Exhibition [exhibitionid=" + exhibitionid + ", name=" + name + ", time=" + time + ", artist="
					+ artist + "]";
		}



		

}
