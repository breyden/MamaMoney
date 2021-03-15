package com.mkyong;

import java.math.BigDecimal;

public class Response {
  
    private Request req;
    private String message;

    public Response (Request req, String message) {
        this.req = req;
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "sessionId=" + req.getSessionId()+
                ", message='" + this.message+ 
                '}';
    }

}
