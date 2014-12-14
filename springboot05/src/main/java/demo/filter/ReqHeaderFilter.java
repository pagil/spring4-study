package demo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.*;

@Component
public class ReqHeaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest = getSubstituteRequest(servletRequest);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private ServletRequest getSubstituteRequest(ServletRequest servletRequest) {
        CustomHttpRequest request = new CustomHttpRequest((HttpServletRequest) servletRequest);
        request.addHeader("MyHeaderName", "MyHeaderValue");
        return request;
    }

    @Override
    public void destroy() {

    }


    public class CustomHttpRequest extends HttpServletRequestWrapper {
        private HttpServletRequest originalRequest;
        private Map<String, String> customHeaders = new HashMap<>();

        public CustomHttpRequest(HttpServletRequest servletRequest) {
            super(servletRequest);
            originalRequest = servletRequest;
        }

        @Override
        public String getHeader(String headerName) {
            Optional<String> header = Optional.ofNullable(super.getHeader(headerName));
            return header.orElse(customHeaders.get(headerName));
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            List<String> names = new ArrayList<>();
            Enumeration<String> originalHeaders = originalRequest.getHeaderNames();
            while (originalHeaders.hasMoreElements()) {
                names.add(originalHeaders.nextElement());
            }
            customHeaders.keySet().stream().forEach(chn -> names.add(chn));
            return Collections.enumeration(names);
        }

        public void addHeader(String headerName, String headerValue) {
            customHeaders.put(headerName, headerValue);
        }
    }
}
