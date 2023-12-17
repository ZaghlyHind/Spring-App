package com.example.cvtheque.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class RhSessionUtil {
    private int loggedInRhId;
    public int getLoggedInRhId() {
        return loggedInRhId;
    }
    public void setLoggedInRhId(int rhId) {
        this.loggedInRhId = rhId;
    }
}
