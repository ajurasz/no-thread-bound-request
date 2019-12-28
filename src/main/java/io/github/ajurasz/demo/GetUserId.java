package io.github.ajurasz.demo;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
class GetUserId {
    private static final String USER_ID_KEY = "X-USER-ID";
    private final HttpServletRequest httpRequest;

    GetUserId(HttpServletRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    String userId() {
        return Optional.ofNullable(httpRequest.getHeader(USER_ID_KEY))
                .orElseThrow(UserIdNotFound::new);
    }

    static class UserIdNotFound extends RuntimeException {
    }
}
