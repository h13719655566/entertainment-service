package com.hdalgorithm.entertainment_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdalgorithm.entertainment_service.model.response.WhatsOnResponse;
import org.locationtech.spatial4j.io.GeohashUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class WhatsOnService {

    @Value("${ticketmaster.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public WhatsOnService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public WhatsOnResponse getEventsForLocation() {
        // Wollongong
        double latitude = -34.4278;
        double longitude = 150.8931;

        // GeoHash
        String geoHash = GeohashUtils.encodeLatLon(latitude, longitude, 9);

        String url = UriComponentsBuilder.fromHttpUrl("https://app.ticketmaster.com/discovery/v2/events.json")
                .queryParam("apikey", apiKey)
                .queryParam("geoPoint", geoHash)
                .toUriString();

        try {
            System.out.println("Request URL: " + url);
            String jsonResponse = restTemplate.getForObject(url, String.class);

            WhatsOnResponse response = new ObjectMapper().readValue(jsonResponse, WhatsOnResponse.class);
            System.out.println("Parsed Response: " + response);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch events for location: " + e);
        }
    }

    public WhatsOnResponse.Event getEventDetails(String eventId) {
        String url = UriComponentsBuilder.fromHttpUrl("https://app.ticketmaster.com/discovery/v2/events/")
                .path(eventId)
                .queryParam("apikey", apiKey)
                .toUriString();

        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(jsonResponse, WhatsOnResponse.Event.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch event details: " + e);
        }
    }
}
