package com.company.api;

import com.company.model.AuthInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.Map;
@RestController
@RequestMapping("api/auth")
public class AuthTest {
    @GetMapping("/test")
    @PermitAll
    public Map<String, String> test(Authentication authentication) {
        AuthInfo authInfo = (AuthInfo) authentication.getPrincipal();
        return Map.of(
                "email", authentication.getName(),
                "role", authInfo.getRole().name()
        );
    }
}
