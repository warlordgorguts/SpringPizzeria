package pizza.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller    // This means that this class is a Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping(path = "/add")

    public @ResponseBody
    String addNewPizza(@RequestParam String name
            , @RequestParam Float price, @RequestParam String commandToPrepare) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Pizza n = new Pizza();
        n.setName(name);
        n.setPrice(price);
        n.setCommandToPrepare(commandToPrepare);
        pizzaRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/delete")

    public @ResponseBody
    String deletePizza(@RequestParam Integer id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        if (pizzaRepository.existsById(id)) {
            pizzaRepository.deleteById(id);
            return "Deleted";
        } else {
            return "Not found";
        }
    }

    @GetMapping(path = "/update")

    public @ResponseBody
    String updatePizza(@RequestParam Integer id,
                       @RequestParam(value = "name", required=false) String name,
                       @RequestParam(value = "price", required=false) Float price,
                       @RequestParam(value = "commandToPrepare", required=false) String commandToPrepare) {

        if (pizzaRepository.existsById(id)) {
            Pizza n = pizzaRepository.findById(id).get();
            if (name != null){
                n.setName(name);
            }
            if (price != null) {
                n.setPrice(price);
            }
            if (commandToPrepare != null) {
                n.setCommandToPrepare(commandToPrepare);
            }
            pizzaRepository.save(n);
            return "Updated";
        } else {
            return "Not found";
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Pizza> getAllPizzas() {
        // This returns a JSON or XML with the users
        return pizzaRepository.findAll();
    }
}
