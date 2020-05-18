package com.interactuamovil.apps.contactosms.api.sdk;

import com.fasterxml.jackson.databind.JsonNode;
import com.interactuamovil.apps.contactosms.api.client.rest.Notification.ContentProperty;
import com.interactuamovil.apps.contactosms.api.client.rest.Notification.DestinationProperty;
import com.interactuamovil.apps.contactosms.api.client.rest.Notification.NotificationJson;
import com.interactuamovil.apps.contactosms.api.enums.NotificationType;
import com.interactuamovil.apps.contactosms.api.sdk.responses.NotificationResponse;
import com.interactuamovil.apps.contactosms.api.utils.ApiResponse;
import org.apache.log4j.Logger;


public class Notification extends Request{
    private static final Logger logger = Logger.getLogger(Notification.class);

    public Notification(String apiKey, String secretKey, String apiUri) {
        super(apiKey, secretKey, apiUri);
    }

    /**
     * Send template SMS
     * @param msisdn Destination msisdn
     * @param templateSms Template SMS ID
     * @param params Variables to replace on template. If there is not, send null.
     * @return NotificationResponse
     */
    public ApiResponse<NotificationResponse> sendSms(String msisdn, String templateSms, JsonNode params){
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

    /**
     * Send single SMS
     * @param msisdn Destination msisdn
     * @param message Message to send
     * @return NotificationResponse
     */
    public ApiResponse<NotificationResponse> sendSms(String msisdn, String message){
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

    /**
     * Send single Email
     * @param destination Destination Email
     * @param message Message to send
     * @return NotificationResponse
     */
    public ApiResponse<NotificationResponse> sendEmail(String destination, String message){
        NotificationJson notification = new NotificationJson();
        DestinationProperty destinationProperty = new DestinationProperty();
        ContentProperty contentProperty = new ContentProperty();

        destinationProperty.setEmail(destination);
        contentProperty.setMessage(message);

        notification.setApiKey(this.getApiKey());
        notification.setType(NotificationType.EMAIL);
        notification.setDestination(destinationProperty);
        notification.setContent(contentProperty);

        return sendNotification(notification);
    }

    /**
     * Send template Email
     * @param destination Destination Email
     * @param templateEmail Template Email ID
     * @param params Variables to replace on template. If there is not, send null.
     * @return NotificationResponse
     */
    public ApiResponse<NotificationResponse> sendEmail(String destination, String templateEmail, JsonNode params){
        NotificationJson notification = new NotificationJson();
        DestinationProperty destinationProperty = new DestinationProperty();
        ContentProperty contentProperty = new ContentProperty();

        destinationProperty.setEmail(destination);
        contentProperty.setTemplate(templateEmail);

        notification.setApiKey(this.getApiKey());
        notification.setType(NotificationType.EMAIL);
        notification.setDestination(destinationProperty);
        notification.setContent(contentProperty);
        notification.setParams(params);

        return sendNotification(notification);
    }

    /**
     * Send push notification
     * @param tokenPushId Destination token push ID
     * @param message Message to send
     * @return NotificationResponse
     */
    public ApiResponse<NotificationResponse> sendPush(String tokenPushId, String message){
        NotificationJson notification = new NotificationJson();
        DestinationProperty destinationProperty = new DestinationProperty();
        ContentProperty contentProperty = new ContentProperty();

        destinationProperty.setTokenPushId(tokenPushId);
        contentProperty.setMessage(message);

        notification.setApiKey(this.getApiKey());
        notification.setType(NotificationType.PUSH);
        notification.setDestination(destinationProperty);
        notification.setContent(contentProperty);

        return sendNotification(notification);
    }

    /**
     * Send push notification
     * @param notification NotificationJson object
     * @return NotificationResponse
     */
    public ApiResponse<NotificationResponse> sendNotification(NotificationJson notification){
        ApiResponse<NotificationResponse> response;
        NotificationResponse notificationResponse;

        try {
            response = doRequest("notifications", "post", null, notification, false);
            if (response.isOk()) {
                notificationResponse = NotificationResponse.fromJson(response.getRawResponse());
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
