package demo;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class DataApplication {

    public static void main(String[] args) {
    	
    	ConfigurableApplicationContext context = SpringApplication.run(DataApplication.class);
        ClientRepository repository = context.getBean(ClientRepository.class);
        //SpringApplication.run(DataApplication.class, args);
        
        repository.save(new Client("Christophe", "Strozik"));
        repository.save(new Client("Chloe", "O'Brian"));
        repository.save(new Client("Kim", "Strozik"));
        repository.save(new Client("David", "Palmer"));
        repository.save(new Client("Michelle", "Dessler"));
        //fetch all Clients
        Iterable<Client> Clients = repository.findAll();
        System.out.println("Clients trouvés avec la méthode findAll():");
        System.out.println("-------------------------------");
        for (Client Client : Clients) {
            System.out.println(Client);
        }
        System.out.println();
        // fetch an individual Client by ID
        Client Client = repository.findOne(1L);
        System.out.println("Client trouvés avc la méthode findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(Client);
        System.out.println();
        // fetch Clients by last name
        List<Client> bauers = repository.findByNom("Bauer");
        System.out.println("Client trouvés avec la méthode findByNom('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Client bauer : bauers) {
            System.out.println(bauer);}
        context.close();
    }
}
