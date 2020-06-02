/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ubiquo.apps.reach.api.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

/**
 *
 * @author sergeiw
 */
public interface ISerializer {

    <T> T deserialize(String eventString, Class<T> type) throws IOException;
    
    <T> T deserialize(String eventString, TypeReference<T> type) throws IOException;

    JsonNode deserialize(String eventString) throws IOException;

    <T> T deserialize(JsonNode node, Class<T> type) throws IOException;        

    String serialize(Object o) throws IOException;
    
}
