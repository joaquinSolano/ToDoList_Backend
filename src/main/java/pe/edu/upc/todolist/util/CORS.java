package pe.edu.upc.todolist.util;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORS implements Filter {

	// Orígenes fijos: solo esquema + host + puerto, sin rutas ni "/" final
	private static final Set<String> ALLOWED_ORIGINS = Set.of(
			"http://localhost:4200",
			"https://to-do-list-front-git-master-joaquinsolanos-projects.vercel.app"
	);

	// Cualquier deploy de tu proyecto en Vercel:
	// https://to-do-list-front-<lo-que-sea>-joaquinsolanos-projects.vercel.app
	private static final Pattern VERCEL_PREVIEW = Pattern.compile(
			"^https://to-do-list-front(-[a-z0-9-]+)?-joaquinsolanos-projects\\.vercel\\.app$"
	);

	private boolean isAllowed(String origin) {
		return origin != null
				&& (ALLOWED_ORIGINS.contains(origin) || VERCEL_PREVIEW.matcher(origin).matches());
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String origin = request.getHeader("Origin");
		if (isAllowed(origin)) {
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