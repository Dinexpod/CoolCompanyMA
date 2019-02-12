package web;

import java.util.Objects;

public class Request {
    private String url;
    private RequestMethod method;

  public enum RequestMethod {
        GET,
        POST
    }

    public Request(String url, RequestMethod method) {
        this.url = url;
        this.method = method;
    }

    public static Request of(String url, RequestMethod method) {
      return  new Request(url, method);
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
