package com.interactuamovil.apps.contactosms.api.client.rest.Notification;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentProperty {
    @JsonProperty(value="template")
    private String template;
    @JsonProperty(value="params")
    private String params;
    @JsonProperty(value="message")
    private String message;

    public ContentProperty(){}

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
