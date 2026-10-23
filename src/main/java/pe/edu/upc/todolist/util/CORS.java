package pe.edu.upc.todolist.util;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORS implements Filter {

	// Solo esquema + host + puerto: sin rutas y sin "/" final
	private static final Set<String> ALLOWED_ORIGINS = Set.of(
			"http://localhost:4200",
			"http://localhost:4200/notes",
			"http://localhost:4200/users",
			"https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app"
	);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String origin = request.getHeader("Origin");
		if (origin != null && ALLOWED_ORIGINS.contains(origin)) {
			response.setHeader("Access-Control-Allow-Origin", origin);
			response.setHeader("Vary", "Origin");
		}
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Expose-Headers", "xsrf-token");

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, res);
		}
	}
}

//	@Override
//	public void destroy() {
//		// Código de limpieza si es necesario
//	}
//}
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


//response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/");
//response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/notes");
//response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/notes/nuevo");
//response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/users");
//response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-h0ot1c8ws-joaquinsolanos-projects.vercel.app/newusers");// Frontend deploy