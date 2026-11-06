package org.quickr.oct26_2026.basic;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {
    public String greet(String name) { return "welcome " + name; }
}
