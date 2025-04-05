package com.fodi.ChatGPT.controller;
import com.fodi.ChatGPT.model.Support;
import com.fodi.ChatGPT.repository.SupportRepository;
import com.fodi.ChatGPT.service.MistralService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.HTTP;

@RestController
@RequestMapping(("/api"))
public class MistralController {
    private final SupportRepository supportRepository;
    private final MistralService mistralService;
    @Autowired
    public MistralController(MistralService mistralService, SupportRepository supportRepository) {
        this.mistralService = mistralService;
        this.supportRepository = supportRepository;
    }

    @GetMapping(value = "/chat")
    public ResponseEntity<String> giveResponse(@RequestParam String q) {
        System.out.println(q);
        String response = mistralService.generateText(q);
        supportRepository.save(new Support(q, response));
        return ResponseEntity.status(HttpStatus.OK).body(response) ;
    }
}
