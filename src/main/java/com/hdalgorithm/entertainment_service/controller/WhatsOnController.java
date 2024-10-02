package com.hdalgorithm.entertainment_service.controller;

import com.hdalgorithm.entertainment_service.model.response.WhatsOnResponse;
import com.hdalgorithm.entertainment_service.service.WhatsOnService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WhatsOnController {

    private final WhatsOnService whatsOnService;

    public WhatsOnController(WhatsOnService whatsOnService) {
        this.whatsOnService = whatsOnService;
    }

    @GetMapping("/entertainment/whats-on")
    public WhatsOnResponse getWhatsOn() {
        return whatsOnService.getEventsForLocation();
    }

    @GetMapping("/entertainment/event/{eventId}")
    public WhatsOnResponse.Event getEventDetails(@PathVariable String eventId) {
        return whatsOnService.getEventDetails(eventId);
    }
}