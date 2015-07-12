package org.samples.javaee7.arquillian;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by aparna on 7/12/15.
 */
public class NullFailTest {

    @Test
    public void testNullJsonMappingException() throws JsonProcessingException {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", "Test");
        data.put("NULL", null);

        Employee employee = new Employee("Aparna", 12345, data);

        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals("{\"name\":\"Aparna\",\"id\":12345,\"data\":{\"NULL\":null,\"id\":\"Test\"}}", objectMapper.writeValueAsString(employee));
    }

}
