package com.interactuamovil.apps.contactosms.api.sdk.responses;

import com.interactuamovil.apps.contactosms.api.client.rest.Notification.NotificationJson;
import com.interactuamovil.apps.contactosms.api.sdk.Notification;
import com.interactuamovil.apps.contactosms.api.utils.JsonObject;

import java.io.IOException;

public class NotificationResponse extends JsonObject {

    private String status;
    private NotificationJson result;

    public static NotificationResponse fromJson(String json) throws IOException {
        return JsonObject.fromJson(json, NotificationResponse.class);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NotificationJson getResult() {
        return result;
    }

    public void setResult(NotificationJson result) {
        this.result = result;
    }
}
