package demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/print")
public class HeadersController {

    @RequestMapping(value = "/headers", method = GET)
    public Map<String, String> getRequestHeaders(HttpServletRequest request) {
        Map<String, String> result = Collections.list(request.getHeaderNames()).stream().collect(Collectors.toMap(h -> h, h -> request.getHeader(h)));
        return result;
    }

// This method causes NPE because Spring tried to get the values for the whole list of header names returned by ReqHeaderFilter
// but fails at attempt to get values: webRequest.getHeaderValues(headerName)
// Here is the stack trace:
//    java.lang.NullPointerException: null
//    at org.springframework.web.method.annotation.RequestHeaderMapMethodArgumentResolver.resolveArgument(RequestHeaderMapMethodArgumentResolver.java:69)
//
//    @RequestMapping(value = "/headers", method = GET)
//    public Map<String, String> getRequestHeaders(@RequestHeader HttpHeaders headers) {
//        return headers.toSingleValueMap();
//    }
}
