package mate.academy.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Request {
    private String url;
    private RequestMethod method;
    Map<String, String[]> params;

    public enum RequestMethod {
        GET,
        POST
    }

    public Request(String url, RequestMethod method, Map<String, String[]> param) {
        this.url = url;
        this.method = method;
        this.params = param;
    }

    public static Request of(String url, RequestMethod method) {
        return new Request(url, method, new HashMap<>());
    }

    public static Request of(String url, RequestMethod method, Map<String, String[]> param) {
        return new Request(url, method, param);
    }

    public String getParamByName(String name) {
        return params.get(name)[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(url, request.url) &&
                method == request.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, method);
    }
}
