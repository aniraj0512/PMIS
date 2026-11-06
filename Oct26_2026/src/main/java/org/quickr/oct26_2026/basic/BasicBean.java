package org.quickr.oct26_2026.basic;

public class BasicBean {
    private final String name;
    public BasicBean(String name) {
        this.name=name;
    }
    public String getName() {
        return "Hello"+name;
    }
}
