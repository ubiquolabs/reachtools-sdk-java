package com.interactuamovil.apps.contactosms.api.client.rest.Notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.interactuamovil.apps.contactosms.api.enums.NotificationType;
import com.interactuamovil.apps.contactosms.api.utils.JsonObject;
import com.sun.istack.internal.NotNull;

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
}
