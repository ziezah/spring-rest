package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private Greeting x;
    
    @Autowired 
    private EntityManagerFactory em;
    

    @CrossOrigin(origins={"*"})
    @RequestMapping("/actors")
    public List<Actor> allActors (){
    	return em.createEntityManager()
    			.createQuery("from Actor")
    			.getResultList();
    }
    
    @CrossOrigin(origins={"*"})
    @RequestMapping("/films")
    public List<Film> allFilms (){
    	return em.createEntityManager()
    			.createQuery("from Film")
    			.getResultList();
    }
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return x;

    	}
    
    @Bean("abc")
    public Greeting sample() {
    	return new Greeting(18,"BPKP");
    }
}
