package com.interactuamovil.apps.contactosms.api.client.rest.Notification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.interactuamovil.apps.contactosms.api.enums.NotificationType;
import com.interactuamovil.apps.contactosms.api.utils.JsonObject;
import com.sun.istack.internal.NotNull;

import java.io.IOException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationJson extends JsonObject {
    @JsonProperty(value="destination")
    private DestinationProperty destination;
    @JsonProperty(value="content")
    private ContentProperty content;
    @NotNull
    @JsonProperty(value="api_key")
    private String apiKey;
    @JsonProperty(value="type")
    private NotificationType type;
    @JsonProperty(value="callback")
    private String callback;
    @JsonProperty(value="meta")
    private JsonNode meta;
    @JsonProperty(value="template")
    private String template;
    @JsonProperty(value="params")
    private JsonNode params;

    public NotificationJson(){}

    public static NotificationJson fromJson(String json) throws IOException {
        return JsonObject.fromJson(json, NotificationJson.class);
    }

    public DestinationProperty getDestination() {
        return destination;
    }

    public void setDestination(DestinationProperty destination) {
        this.destination = destination;
    }

    public ContentProperty getContent() {
        return content;
    }

    public void setContent(ContentProperty content) {
        this.content = content;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public JsonNode getMeta() {
        return meta;
    }

    public void setMeta(JsonNode meta) {
        this.meta = meta;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public JsonNode getParams() {
        return params;
    }

    public void setParams(JsonNode params) {
        this.params = params;
    }
}
