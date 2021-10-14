package Server_Programming.ExhibitionApplication;

import java.util.List;

import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import Server_Programming.ExhibitionApplication.domain.ArtistRepository;
import Server_Programming.ExhibitionApplication.domain.Exhibition;
import Server_Programming.ExhibitionApplication.domain.ExhibitionRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace = NONE)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ExhibitionRepositoryTest {

	@Autowired
	ExhibitionRepository erepository;
	
	@Autowired
	ArtistRepository arepository;

	@Test
	public void findByAuthorShouldReturnAuthor() {
		List<Exhibition> exhibitions = erepository.findByName("Sonic Blossom");
		System.out.println("TESTING: FindByName: " + exhibitions);
		System.out.println("TESTING: FindAll:" +  erepository.findAll());
		
		Assertions.assertThat(exhibitions.get(0).getName()).isEqualTo("Sonic Blossom");
	}

	@Test
	public void findByNameShouldReturnSize() {
		List<Exhibition> exhibitions = erepository.findByName("Sonic Blossom");
		Assertions.assertThat(exhibitions).hasSize(1);

	}

	@Test
	public void insertNewExhibition() {
		Exhibition exhibition = new Exhibition("Off Topic", "02.06.2021-12.12.2021", arepository.findByName("Emma Jääskeläinen").get(0));
		erepository.save(exhibition);
		List<Exhibition> exhibitions = erepository.findByName("Off Topic");
		Assertions.assertThat(exhibitions.get(0).getName()).isEqualTo("Off Topic");

	}

}

