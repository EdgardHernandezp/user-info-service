package com.dreamseeker.userinfoservice.services;

import java.net.URI;
import java.util.Optional;

import com.dreamseeker.userinfoservice.domains.Recommendation;
import com.dreamseeker.userinfoservice.domains.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class RecommendationService {
    public Recommendation fetchRecommendations(UserInfo userInfo, Optional<String> exclusions) {
        RestClient restClient = RestClient.create();
        String uri = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(14257)
                .path("/fetch-recommendations")
                .queryParamIfPresent("exclusions", exclusions)
                .toUriString();
        return restClient.put()
                .uri(URI.create(uri))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .body(userInfo)
                .retrieve()
                .body(Recommendation.class);
    }
}
