package com.hdalgorithm.entertainment_service.model.response;

import lombok.Data;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WhatsOnResponse {
    private Embedded _embedded;
    private Links _links;
    private Page page;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Embedded {
        private List<Event> events;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Event {
        private String name;
        private String type;
        private String id;
        private String url;
        private String locale;
        private List<Image> images;
        private Sales sales;
        private Dates dates;
        private List<Classification> classifications;
        private String info;
        private String pleaseNote;
        private List<PriceRange> priceRanges;
        private Seatmap seatmap;
        private Links _links;
        private boolean test;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Image {
        private String ratio;
        private String url;
        private int width;
        private int height;
        private boolean fallback;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sales {
        @JsonProperty("public")
        private PublicSale publicSale;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PublicSale {
        private String startDateTime;
        private boolean startTBD;
        private boolean startTBA;
        private String endDateTime;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Dates {
        private Start start;
        private String timezone;
        private Status status;
        private boolean spanMultipleDays;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Start {
        private String localDate;
        private String localTime;
        private String dateTime;
        private boolean dateTBD;
        private boolean dateTBA;
        private boolean timeTBA;
        private boolean noSpecificTime;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Status {
        private String code;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Classification {
        private boolean primary;
        private Segment segment;
        private Genre genre;
        private SubGenre subGenre;
        private Type type;
        private SubType subType;
        private boolean family;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Segment {
        private String id;
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Genre {
        private String id;
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubGenre {
        private String id;
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Type {
        private String id;
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SubType {
        private String id;
        private String name;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PriceRange {
        private String type;
        private String currency;
        private double min;
        private double max;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Seatmap {
        private String staticUrl;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Links {
        private Self self;
        private List<Attraction> attractions;
        private List<Venue> venues;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Self {
        private String href;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Attraction {
        private String href;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Venue {
        private String href;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Page {
        private int size;
        private int totalElements;
        private int totalPages;
        private int number;
    }
}