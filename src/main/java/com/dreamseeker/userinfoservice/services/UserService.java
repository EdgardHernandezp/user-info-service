package com.dreamseeker.userinfoservice.services;

import java.util.List;

import com.dreamseeker.userinfoservice.domains.Recommendation;
import com.dreamseeker.userinfoservice.domains.UserInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final RecommendationService recommendationService;

    public Recommendation fetchUser() {
        UserInfo userInfo = new UserInfo("1", List.of("Adventure", "Stealth"));
        return recommendationService.fetchRecommendations(userInfo);
    }
}
