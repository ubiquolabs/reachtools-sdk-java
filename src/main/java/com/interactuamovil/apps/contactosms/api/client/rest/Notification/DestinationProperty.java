package com.interactuamovil.apps.contactosms.api.client.rest.Notification;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationProperty {
    @JsonProperty(value="msisdn")
    private String msisdn;
    @JsonProperty(value="email")
    private String email;

    public DestinationProperty(){}

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
