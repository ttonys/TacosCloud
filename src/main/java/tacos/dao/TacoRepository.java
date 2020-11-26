package tacos.dao;

import org.springframework.data.repository.CrudRepository;

public interface TacoRepository
    extends CrudRepository<Taco, String> {
}
