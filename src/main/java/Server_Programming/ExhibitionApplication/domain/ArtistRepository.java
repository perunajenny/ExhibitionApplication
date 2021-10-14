package Server_Programming.ExhibitionApplication.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArtistRepository extends CrudRepository<Artist, Long> {

	List<Artist> findByName(@Param("name")String name);
}
