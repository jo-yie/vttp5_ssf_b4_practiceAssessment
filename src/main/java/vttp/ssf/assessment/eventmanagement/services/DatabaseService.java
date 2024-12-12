package vttp.ssf.assessment.eventmanagement.services;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Service
public class DatabaseService {

    @Autowired
    RedisRepository redisRepository; 
    
    // Task 1

    // return list of events in console
    public List<Event> readFile(String fileName) throws FileNotFoundException { 

        // list to hold events 
        List<Event> events = new ArrayList<>(); 

        String path = "data/" + fileName;

        // read "events.json" using a stream 
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        
        if (inputStream == null) {
            throw new FileNotFoundException("events.json not found");
        }

        // use JsonReader to read stream 
        JsonReader jReader = Json.createReader(inputStream);

        // read JsonArray of objects 
        // [{}, {}, {}]
        JsonArray jArray = jReader.readArray(); 

        for (JsonValue jvEvent : jArray) {

            // cast JsonValue into JsonObject 
            JsonObject joEvent = (JsonObject) jvEvent; 

            // extract information 
            Integer eventId = joEvent.getInt("eventId");
            String eventName = joEvent.getString("eventName");
            Integer eventSize = joEvent.getInt("eventSize");
            Long eventDate = (long) joEvent.getInt("eventDate");
            Integer participants = joEvent.getInt("participants");

            // create Event POJO 
            Event event = new Event(eventId, eventName, eventSize, eventDate, participants);

            // add event to list (for printing to console)
            events.add(event);

            // save event to redis 
            redisRepository.saveRecord(event);

        }

        return events;
    }

}
