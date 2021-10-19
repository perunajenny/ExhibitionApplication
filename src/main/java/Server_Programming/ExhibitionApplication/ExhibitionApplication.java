package Server_Programming.ExhibitionApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Server_Programming.ExhibitionApplication.domain.Artist;
import Server_Programming.ExhibitionApplication.domain.ArtistRepository;
import Server_Programming.ExhibitionApplication.domain.Exhibition;
import Server_Programming.ExhibitionApplication.domain.ExhibitionRepository;
import Server_Programming.ExhibitionApplication.domain.Museum;
import Server_Programming.ExhibitionApplication.domain.MuseumRepository;
import Server_Programming.ExhibitionApplication.domain.User;
import Server_Programming.ExhibitionApplication.domain.UserRepository;



@SpringBootApplication
public class ExhibitionApplication {
	private static final Logger log = LoggerFactory.getLogger(ExhibitionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExhibitionApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner exhibitionapplication(ArtistRepository arepository, MuseumRepository mrepository, ExhibitionRepository erepository, UserRepository urepository) {
		return (args) -> {
			log.info("save some data");
			
			mrepository.save(new Museum("Ateneum","Finland","Kaivokatu 2"));
			mrepository.save(new Museum("Kiasma", "Finland", "Mannerheiminaukio 2"));
	
			arepository.save(new Artist("Emma Jääskeläinen", "Finland", 1988));
			arepository.save(new Artist("Lee Mingwei", "Taiwan", 1964));
			
			/*
			erepository.save(new Exhibition("Proper Omelette", "2.6.2020-10.1.2021", arepository.findByName("Emma Jääskeläinen").get(0)));
			erepository.save(new Exhibition("Sonic Blossom", "24.9.-24.10.2021", arepository.findByName("Lee Mingwei").get(0)));
			*/
			
			erepository.save(new Exhibition("Proper Omelette", "2.6.2020-10.1.2021", arepository.findByName("Emma Jääskeläinen").get(0), mrepository.findByName("Kiasma").get(0)));
			erepository.save(new Exhibition("Sonic Blossom", "24.9.-24.10.2021", arepository.findByName("Lee Mingwei").get(0), mrepository.findByName("Ateneum").get(0)));
			
			
			User user1 = new User("user", "$2a$10$DRw6dIwHoniI4TDRUNy63ODpUjVUsrI5b/XKFopj0tOMigkC4tnq2", "USER");
			User user2 = new User("admin", "$2a$10$XD8eH.b/Xt5c7y0KcjnKkOFEvRS2RyU97.A6IUgkmk.lPQtslA2i2", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all exhibitions");
			for (Exhibition exhibition : erepository.findAll()) {
				log.info(exhibition.toString());
			}

		};
	}
	

}
