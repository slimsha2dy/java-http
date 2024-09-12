package org.apache.coyote.http11;

import java.util.Map;

public class HttpRequest {

    private HttpMethod method;
    private String path;
    private Map<String, String> queryString;
    private String protocolVersion;
    private Map<String, String> headers;
    private HttpCookie httpCookie;
    private Session session;
    private String body;

    public HttpRequest(HttpMethod method, String path, Map<String, String> queryString, String protocolVersion,
                       Map<String, String> headers, HttpCookie httpCookie, Session session, String body) {
        this.method = method;
        this.path = path;
        this.queryString = queryString;
        this.protocolVersion = protocolVersion;
        this.headers = headers;
        this.httpCookie = httpCookie;
        this.session = session;
        this.body = body;
    }

    public boolean hasMethod(HttpMethod method) {
        return this.method == method;
    }

    public boolean hasPath(String path) {
        return this.path.equals(path);
    }

    public boolean hasQueryString() {
        return !queryString.isEmpty();
    }

    public boolean hasCookieFrom(String input) {
        return httpCookie.hasValue(input);
    }

    public String getQueryData(String input) {
        return queryString.get(input);
    }

    public String getHeaderData(String input) {
        return headers.get(input);
    }

    public String getPath() {
        return this.path;
    }

    public Session getSession() {
        return session;
    }

    public String getBody() {
        return body;
    }
}
