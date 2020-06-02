# Reach Tools Java SDK
Este SKD facilita la comunicacion con el API de Reach, para el envio de emails y mensajes SMS.

## Antes de empezar
Para utilizar el SDK de java, debe poseer una cuenta en la plataforma de Reach, desde donde se realizaran los envíos.  
El API_URL necesario para el envio de mensajes es `https://api.reach.tools/notifications`. <p>
Y como autentificación necesitara proveer un API_KEY, API_SECRET_KEY.

### Requisitos
* Maven >= 3.6.0
* Java >= 1.8.0

## Utilización
Instalar el sdk y añadirlo al pom.xml como: 
```java
<dependency>
  <groupId>io.ubiquo.apps.reach</groupId>
  <artifactId>reachtools-sdk-java</artifactId>
  <version>1.0.1-SNAPSHOT</version>
</dependency>
```

Importar la clase Notification
```java
import io.ubiquo.apps.reach.api.sdk.Notification;
```

Crear una instancia de Notification con los siguientes parametros:
```java
Notification notificationApi = new Notification(API_KEY, API_SECRET_KEY, API_URL);
```

Con esta instancia ya se pueden realizar distintos tipos de envio.

### Métodos de envio
```java
notificationApi.sendSms(MSISDN, MESSAGE); //Envio individual de SMS
notificationApi.sendSms(MSISDN, SMS_TEMPLATE_ID, SMS_PARAMS); //Envio SMS por plantilla
notificationApi.sendEmail(DESTINATION_EMAIL, MESSAGE); //Envio individual de Email
notificationApi.sendEmail(DESTINATION_EMAIL, EMAIL_TEMPLATE_ID, EMAIL_PARAMS); //Envio Email por plantilla
```
Donde:
* MSISDN (**String**): Número de teléfono
* MESSAGE (**String**): El mensaje a enviar
* SMS_TEMPLATE_ID (**String**): ID de plantilla SMS válida 
* DESTINATION_EMAIL (**String**): Correo destino
* EMAIL_TEMPLATE_ID (**String**): ID de plantilla Email válida

Y:
* EMAIL_PARAMS (**JsonNode**): Variables a reemplazar en la plantilla de Email (Si no hay variables que reemplazar, enviar **null**). Ejemplo del formato del JsonNode:
```json
{
  "var1" : "value1",
  "var2" : "value2"
}
```
* SMS_PARAMS (**JsonNode**): Variables a reemplazar en la plantilla de SMS (Si no hay variables que reemplazar, enviar **null**). Ejemplo del formato del JsonNode:
```json
{
  "variables" : {
    "var1" : "value1",
    "var2" : "value2",
  }
}
```

### Respuesta
Los métodos devuelvem un `ApiResponse<NotificationResponse>` definido en `io.ubiquo.apps.reach.api.utils.ApiResponse`. <p>
De ocurrir un error dentro del sdk, el `.getErrorCode()` contendra valor de -1.<p>
De ocurrir un error en el servidor API se puede verificar si se creo el mensaje correctamente con `.isOk()` el cual devuelve `true` si fue correcto.