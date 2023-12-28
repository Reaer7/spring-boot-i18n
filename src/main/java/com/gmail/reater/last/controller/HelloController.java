package com.gmail.reater.last.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name, HttpServletRequest request) {
        return messageSource.getMessage(
                "welcome.message",
                new Object[]{name},
                localeResolver.resolveLocale(request)
        );
    }
}
