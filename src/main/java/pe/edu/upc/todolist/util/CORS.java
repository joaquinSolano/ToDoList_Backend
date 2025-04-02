package pe.edu.upc.todolist.util;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORS implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/");
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/notes");
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/notes/nuevo");
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/users");
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/newusers");// Frontend deploy
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
		response.addHeader("Access-Control-Expose-Headers", "xsrf-token");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
		// Código de limpieza si es necesario
	}
}
	//Usar para uso local, aplicar en application properties
	//spring.application.name=ToDoList
	//spring.jpa.database=postgresql
	//spring.jpa.show-sql=false
	//spring.jpa.hibernate.ddl-auto=update
	//spring.datasource.driver-class-name=org.postgresql.Driver
	//spring.datasource.url=jdbc:postgresql://localhost/DB_ToDoList
	//spring.datasource.username=postgres
	//spring.datasource.password=040402
	//server.port=8081