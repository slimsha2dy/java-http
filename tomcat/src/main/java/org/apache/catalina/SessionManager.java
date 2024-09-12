package org.apache.catalina;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.coyote.http11.Session;

public class SessionManager implements Manager {

    private static final Map<String, Session> SESSIONS = new HashMap<>();
    private static SessionManager sessionManager;

    private SessionManager() {
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session create() {
        String id = UUID.randomUUID().toString();
        Session session = new Session(id);
        add(session);
        return session;
    }

    @Override
    public void add(Session session) {
        SESSIONS.put(session.getId(), session);
    }

    @Override
    public Session findSession(String id) {
        return SESSIONS.get(id);
    }

    @Override
    public void remove(String id) {
        SESSIONS.remove(id);
    }
}
