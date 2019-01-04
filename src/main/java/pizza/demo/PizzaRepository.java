package pizza.demo;

import org.springframework.data.repository.CrudRepository;

import pizza.demo.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {

}
