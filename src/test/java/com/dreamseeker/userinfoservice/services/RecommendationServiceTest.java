package com.dreamseeker.userinfoservice.services;

import java.util.List;
import java.util.UUID;

import com.dreamseeker.userinfoservice.domains.Recommendation;
import com.dreamseeker.userinfoservice.domains.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(
        ids = {"com.dreamseeker:videogame-recommendation-service:0.0.1-SNAPSHOT:stubs:14257"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
class RecommendationServiceTest {

    @Test
    void fetchRecommendations() {
        RecommendationService recommendationService = new RecommendationService();
        UserInfo userInfo = new UserInfo(UUID.randomUUID().toString(), List.of("Adventure", "Stealth", "Platformer"));
        Recommendation recommendation = recommendationService.fetchRecommendations(userInfo);

        assertThat(recommendation).isNotNull();
        assertThat(recommendation.videogames()).isNotNull().hasSizeGreaterThan(0);
    }
}