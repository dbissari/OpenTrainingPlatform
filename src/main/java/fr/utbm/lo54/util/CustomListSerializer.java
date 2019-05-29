/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fr.utbm.lo54.entity.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edemos
 * Show list of attendees id in CourseSession Json model
 */
public class CustomListSerializer extends StdSerializer<List<Client>> {
    
    public CustomListSerializer() {
        this(null);
    }
    
    public CustomListSerializer(Class<List<Client>> clients) {
        super(clients);
    }

    @Override
    public void serialize(List<Client> clients, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
        List<Integer> ids = new ArrayList<>();
        for (Client c : clients) {
            ids.add(c.getId());
        }
        jg.writeObject(ids);
    }
    
}
