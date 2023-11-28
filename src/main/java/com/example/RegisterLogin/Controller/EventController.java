package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Entity.EventData;
import com.example.RegisterLogin.Repo.EventDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper; // JSON processing
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventDataRepository repository;

//    @PostMapping
//    public ResponseEntity<EventData> createEvent(@RequestBody EventData eventData) {
//        return ResponseEntity.ok(repository.save(eventData));
//    }
@PostMapping("/create-event")
public ResponseEntity<EventData> createOrUpdateEvent(@RequestPart("event") String eventJson,
                                                     @RequestPart(value = "file", required = false) MultipartFile file) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
        EventData eventData = objectMapper.readValue(eventJson, EventData.class);
        if (file != null && !file.isEmpty()) {
            eventData.setInvitationImageData(file.getBytes());
        }
        //  System.out.println(eventData);
        eventData = repository.save(eventData);
        return ResponseEntity.ok(eventData);
    } catch (IOException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

    @GetMapping
    public ResponseEntity<List<EventData>> getAllEvents() {
        return ResponseEntity.ok(repository.findAll());
 }

    @GetMapping("/{id}")
    public ResponseEntity<EventData> getEventById(@PathVariable Long id) {
        System.out.println(id);
    return repository.findById(id)
                .map(eventData -> ResponseEntity.ok(eventData))
                .orElse(ResponseEntity.notFound().build());
    }
//    @CrossOrigin
//    @PostMapping("/upload-image")
//    public ResponseEntity<EventData> uploadImage(@RequestPart("file") MultipartFile file,
//                                                 @RequestPart("event") String eventJson) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            EventData eventData = objectMapper.readValue(eventJson, EventData.class);
//            eventData.setInvitationImageData(file.getBytes());
//            EventData savedEventData = repository.save(eventData);
//            return ResponseEntity.ok(savedEventData);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }
//        }

    @GetMapping("/{id}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        return repository.findById(id)
                .map(eventData -> ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // Adjust the content type if needed
                        .body(eventData.getInvitationImageData()))
                .orElse(ResponseEntity.notFound().build());
    }



}