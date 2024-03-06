package com.dreamseeker.userinfoservice.services;

import com.dreamseeker.userinfoservice.domains.Recommendation;
import com.dreamseeker.userinfoservice.domains.UserInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RecommendationService {
    public Recommendation fetchRecommendations(UserInfo userInfo) {
        String port = "14257";
        WebClient webClient = WebClient.create("http://localhost:" + port);
        return webClient.put()
                .uri("/fetch-recommendations")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(userInfo), UserInfo.class)
                .retrieve()
                .bodyToMono(Recommendation.class)
                .block();
    }
}
