package com.interactuamovil.apps.contactosms.api.sdk;

import com.fasterxml.jackson.databind.JsonNode;
import com.interactuamovil.apps.contactosms.api.client.rest.Notification.NotificationJson;
import com.interactuamovil.apps.contactosms.api.utils.ApiResponse;
import org.apache.log4j.Logger;

public class Notification extends Request{
    private static final Logger logger = Logger.getLogger(Notification.class);

    public Notification(String apiKey, String secretKey, String apiUri) {
        super(apiKey, secretKey, apiUri);
    }

    //variables params missing
    public ApiResponse<NotificationJson> sendTemplateSms(String msisdn, String templateSms){
        String type = "SMS";
        return new ApiResponse<NotificationJson>();
    }

    public ApiResponse<NotificationJson> sendIndividualSms(String msisdn, String message){
        String type = "SMS";
        return new ApiResponse<NotificationJson>();
    }

    public ApiResponse<NotificationJson> sendIndividualEmail(String destination, String templateEmail, String params){
        String type = "EMAIL";
        return new ApiResponse<NotificationJson>();
    }
}
