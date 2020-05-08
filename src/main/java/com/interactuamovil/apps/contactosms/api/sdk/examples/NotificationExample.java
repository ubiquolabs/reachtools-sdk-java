package com.interactuamovil.apps.contactosms.api.sdk.examples;

import com.fasterxml.jackson.databind.JsonNode;
import com.interactuamovil.apps.contactosms.api.sdk.Notification;
import org.apache.commons.configuration.Configuration;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class NotificationExample extends BaseExample{

    private String testMsisdn = null;
    private String testDestination = null;
    private String testTemplateSms = null;
    private String testTemplateEmail = null;
    private String testParams = null;
    private String testMessage = null;

    public NotificationExample(String _apiKey, String _apiSecretKey, String _apiUri, Configuration _config) {
        super(_apiKey, _apiSecretKey, _apiUri, _config);
    }

    @Override
    public void configure(){
        testMsisdn = getConfig().getString("test_msisdn");
        testDestination = getConfig().getString("test_email");
        testTemplateSms = getConfig().getString("test_template_sms");
        testTemplateEmail = getConfig().getString("test_template_email");
        testParams = getConfig().getString("test_params");
        testMessage = getConfig().getString("test_message");

        if (null == testMsisdn || null == testDestination || null == testTemplateSms
                || null == testTemplateEmail || null == testParams || null == testMessage) {
            throw new AssertionError(
                    "Please add contact configurations:"
                            + "test_msisdn, test_email, test_template_sms,"
                            + "test_template_email, test_params, test_message."
            );
        }
    }

    @Override
    public void test() throws IOException, InvalidKeyException, NoSuchAlgorithmException {
        Notification notificationApi = new Notification(
                getApiKey(), getApiSecretKey(), getApiUri()
        );
        notificationApi.sendTemplateSms(testMsisdn, testTemplateSms);
        notificationApi.sendIndividualSms(testMsisdn, testMessage);
        notificationApi.sendIndividualEmail(testDestination, testTemplateEmail, testParams);
    }
}
