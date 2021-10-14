package Server_Programming.ExhibitionApplication.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MuseumRepository extends CrudRepository<Museum, Long> {

	List<Museum> findByName(String name);
}
