package com.example.cvtheque.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionUtil {

    private int loggedInCandidatId; // Cette variable stockera l'ID du candidat connecté
    private Long loggedInUserId;

    public Long getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(Long loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }

    public int getLoggedInCandidatId() {
        return loggedInCandidatId;
    }

    public void setLoggedInCandidatId(int candidatId) {
        this.loggedInCandidatId = candidatId;
    }

}

