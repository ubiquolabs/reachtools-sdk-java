package com.interactuamovil.apps.contactosms.api.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.interactuamovil.apps.contactosms.api.client.rest.Notification.ContentProperty;
import com.interactuamovil.apps.contactosms.api.client.rest.Notification.DestinationProperty;
import com.interactuamovil.apps.contactosms.api.client.rest.Notification.NotificationJson;
import com.interactuamovil.apps.contactosms.api.enums.NotificationType;
import com.interactuamovil.apps.contactosms.api.utils.ApiResponse;
import com.interactuamovil.apps.contactosms.api.utils.JsonObjectCollection;
import org.apache.log4j.Logger;

import java.util.List;

public class Notification extends Request{
    private static final Logger logger = Logger.getLogger(Notification.class);

    public Notification(String apiKey, String secretKey, String apiUri) {
        super(apiKey, secretKey, apiUri);
    }

    public ApiResponse<NotificationJson> sendTemplateSms(String msisdn, String templateSms, JsonNode params){
        NotificationJson notification = new NotificationJson();
        DestinationProperty destinationProperty = new DestinationProperty();

        destinationProperty.setMsisdn(msisdn);
        notification.setApiKey(this.getApiKey());
        notification.setType(NotificationType.SMS);
        notification.setDestination(destinationProperty);
        notification.setTemplate(templateSms);
        notification.setParams(params);

        return sendNotification(notification);
    }

    public ApiResponse<NotificationJson> sendSingleSms(String msisdn, String message){
        NotificationJson notification = new NotificationJson();
        DestinationProperty destinationProperty = new DestinationProperty();
        ContentProperty contentProperty = new ContentProperty();

        destinationProperty.setMsisdn(msisdn);
        contentProperty.setMessage(message);

        notification.setApiKey(this.getApiKey());
        notification.setType(NotificationType.SMS);
        notification.setDestination(destinationProperty);
        notification.setContent(contentProperty);

        return sendNotification(notification);
    }

    public ApiResponse<NotificationJson> sendSingleEmail(String destination, String templateEmail, String message, String params){
        NotificationJson notification = new NotificationJson();
        DestinationProperty destinationProperty = new DestinationProperty();
        ContentProperty contentProperty = new ContentProperty();

        destinationProperty.setEmail(destination);
        contentProperty.setTemplate(templateEmail);
        contentProperty.setParams(params);
        contentProperty.setMessage(message);

        notification.setApiKey(this.getApiKey());
        notification.setType(NotificationType.EMAIL);
        notification.setDestination(destinationProperty);
        notification.setContent(contentProperty);

        return sendNotification(notification);
    }

    public ApiResponse<NotificationJson> sendNotification(NotificationJson notification){
        ApiResponse<NotificationJson> response;
        NotificationJson notificationResponse;

        try {
            response = doRequest("notifications", "post", null, notification, true);
            if (response.isOk()) {
                notificationResponse = JsonObjectCollection.fromJson(response.getRawResponse(), new TypeReference<NotificationJson>() {});
                response.setResponse(notificationResponse);
            }
        } catch (Exception e) {
            response = new ApiResponse<>();
            response.setErrorCode(-1);
            response.setErrorDescription(e.getMessage());
        }

        return response;
    }
}
