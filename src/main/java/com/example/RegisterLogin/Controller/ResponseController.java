package com.example.RegisterLogin.Controller;
import com.example.RegisterLogin.Dto.ResponseDataDTO;
import com.example.RegisterLogin.Entity.EventData;
import com.example.RegisterLogin.Entity.ResponsesData;
import com.example.RegisterLogin.Repo.ResponseDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/response")
public class ResponseController {

    @Autowired
    private ResponseDataRepository repository;

    @PostMapping(value = "/submit-response")
    public ResponseEntity<?> submitResponse(
            @RequestPart("responsesData") String responsesDataJson,
            @RequestPart("invitationImageData") MultipartFile invitationImageData
    ) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ResponsesData responsesData = objectMapper.readValue(responsesDataJson, ResponsesData.class);
            if (!invitationImageData.isEmpty()) {
                byte[] imageData = invitationImageData.getBytes();
                responsesData.setInvitationImageData(imageData);
            }

            System.out.println(responsesData.getEventData());
            ResponsesData savedResponse = repository.save(responsesData);
            return new ResponseEntity<>(savedResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-responses")
    public ResponseEntity<List<ResponseDataDTO>> getAllResponses() {
        try {
            List<ResponsesData> allResponses = repository.findAll();
            List<ResponseDataDTO> dtos = allResponses.stream()
                    .peek(responseData -> {
                        EventData eventData = responseData.getEventData();
                        // Trigger loading of eventData if not loaded (avoiding lazy loading)
                        if (eventData != null) {
                            System.out.println(eventData.getEventTitle()); // Replace with the actual method to fetch the event title
                        }
                    })
                    .map(ResponseDataDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}