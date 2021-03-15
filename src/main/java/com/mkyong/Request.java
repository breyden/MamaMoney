package com.mkyong;

import javax.validation.Valid;
import javax.validation.constraints.*;
public class Request{

    private String sessionId;
    private String msisdn;
    private String userEntry;

    // avoid this "No default constructor for entity"
    public Request() {
    }

    public Request(String sessionId, String msisdn, String userEntry) {
        this.sessionId = sessionId;
        this.msisdn = msisdn;
        this.userEntry = userEntry;
    }

    public Request(String msisdn, String sessionId) {
        this.msisdn = msisdn;
        this.sessionId = sessionId;
    }

    @NotNull(message = "Invalid sessionId")
	@Pattern(
		regexp = "[a-z0-9]{24}",
		message = "Invalid sessionId")
    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @NotNull(message = "Invalid  msisdn")
	@Pattern(
		regexp = "[0-9]{10}",
		message = "Invalid  msisdn")
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getUserEntry() {
        return userEntry;
    }

    public void setUserEntry(String userEntry) {
        this.userEntry = userEntry;
    }
}
