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
	public void init(FilterConfig filterConfig) throws ServletException {
		// Inicialización si es necesaria
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;

		// Especifica la URL de tu frontend aquí
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-psi.vercel.app");
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-psi.vercel.app/login");
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-psi.vercel.app/notes");
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-psi.vercel.app/notes/nuevo");
		response.setHeader("Access-Control-Allow-Origin", "https://to-do-list-front-psi.vercel.app/newuser");
		response.setHeader("Access-Control-Allow-Methods", "DELETE, GET, OPTIONS, PATCH, POST, PUT");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");

		// Manejo de solicitudes OPTIONS
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, res);
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
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
}