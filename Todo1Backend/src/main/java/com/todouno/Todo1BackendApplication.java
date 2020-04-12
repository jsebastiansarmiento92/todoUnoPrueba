package com.todouno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/** clase donde se ejecuta el main que inicia el servidor
 * @author Sebastian Sarmiento Aunta
 * @version 12/04/2020
 */
@SpringBootApplication
public class Todo1BackendApplication {
	/**metodo donde arranca el servidor 
	 * @param args
	 */
	public static void main(String[] args) {
		//metodo donde inicia el hilo del servidor
		SpringApplication.run(Todo1BackendApplication.class, args);
	}

}
