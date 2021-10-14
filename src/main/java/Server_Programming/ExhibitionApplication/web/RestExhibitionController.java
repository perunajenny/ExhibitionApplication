package Server_Programming.ExhibitionApplication.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Server_Programming.ExhibitionApplication.domain.ArtistRepository;
import Server_Programming.ExhibitionApplication.domain.Exhibition;
import Server_Programming.ExhibitionApplication.domain.ExhibitionRepository;

@RestController
public class RestExhibitionController {

	@Autowired
	private ArtistRepository arepository;
	
	@Autowired
	private ExhibitionRepository erepository;
	
	@GetMapping(value="/exhibitionlist")
	public List<Exhibition> exhibitionsRest() {
		return (List<Exhibition>) erepository.findAll();
	}
	
}
