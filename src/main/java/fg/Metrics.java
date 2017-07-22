package fg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Metrics {

	public static void main(String[] args) {
		
		/* run method performs the following things under the hood:
		 * creates the spring container to run the application in its own container
		 * sets up default configuration 
		 * starts spring application context (spring container)
		 * performs class path scan - plug in code by annotating classes with controller/service markers
		 * start tomcat server
		 */
		SpringApplication.run(Metrics.class, args);
		
		
	}

}
