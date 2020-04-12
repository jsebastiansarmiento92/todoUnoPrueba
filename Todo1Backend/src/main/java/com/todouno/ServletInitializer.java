package com.todouno;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/** declaraciopn del servelet con todos los repositorios y clases
 * @author Sebastian Sarmiento Aunta
 * @version 12/04/2020
 */
public class ServletInitializer extends SpringBootServletInitializer {
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Todo1BackendApplication.class);
	}

}
