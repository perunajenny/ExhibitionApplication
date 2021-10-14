package Server_Programming.ExhibitionApplication.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {

	List<Exhibition> findByName(String name);


}
