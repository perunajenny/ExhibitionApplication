package Server_Programming.ExhibitionApplication.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Server_Programming.ExhibitionApplication.domain.Artist;
import Server_Programming.ExhibitionApplication.domain.ArtistRepository;
import Server_Programming.ExhibitionApplication.domain.Exhibition;
import Server_Programming.ExhibitionApplication.domain.ExhibitionRepository;
import Server_Programming.ExhibitionApplication.domain.MuseumRepository;


@Controller
public class ExhibitionController {
	
	@Autowired
	private ArtistRepository arepository;
	
	@Autowired
	private MuseumRepository mrepository;
	
	@Autowired
	private ExhibitionRepository erepository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String returnBook() {
		return "index";
	}
	
    @RequestMapping(value="/exhibitions")
    public String exhibitionList(Model model) {	
        model.addAttribute("exhibitions", erepository.findAll());
        return "exhibitions";
    }
    
    @RequestMapping(value="/artists")
    public String ArtistList(Model model) {	
        model.addAttribute("artists", arepository.findAll());
        return "artists";
    }
	
    @RequestMapping(value = "/addartist")
    public String addArtist(Model model){
    	model.addAttribute("artist", new Artist());
        return "addartist";
    }
    
    @RequestMapping(value = "/saveartist", method = RequestMethod.POST)
    public String save(@Valid Artist artist, BindingResult bindingResult){
    	if (bindingResult.hasErrors()) {
			return "addartist";
		}
        arepository.save(artist);
        return "redirect:artists";
    }
    
    @RequestMapping(value = "/addexhibition")
    public String addExhibition(Model model){
    	model.addAttribute("exhibition", new Exhibition());
    	model.addAttribute("artists", arepository.findAll());
        return "addexhibition";
    }
    
    @RequestMapping(value = "/saveexhibition", method = RequestMethod.POST)
    public String save(@Valid Exhibition exhibition, BindingResult bindingResult){
    	if (bindingResult.hasErrors()) {
			return "addexhibition";
		}
        erepository.save(exhibition);
        return "redirect:exhibitions";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deleteex/{id}", method = RequestMethod.GET)
    public String deleteExhibition(@PathVariable("id") Long exhibitionid, Model model) {
    	erepository.deleteById(exhibitionid);
        return "redirect:../exhibitions";
    } 
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/editex/{id}")
    public String editExhibition(@PathVariable("id") Long exhibitionId, Model model){
    model.addAttribute("exhibition", erepository.findById(exhibitionId));
    model.addAttribute("artists", arepository.findAll());
    model.addAttribute("museums", mrepository.findAll());
    return "editexhibition";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/deleteart/{id}", method = RequestMethod.GET)
    public String deleteArtist(@PathVariable("id") Long artistid, Model model) {
    	arepository.deleteById(artistid);
        return "redirect:../artists";
    } 
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/editart/{id}")
    public String editArtist(@PathVariable("id") Long artistId, Model model){
    model.addAttribute("artist", arepository.findById(artistId));
    return "editartist";
    }
}
