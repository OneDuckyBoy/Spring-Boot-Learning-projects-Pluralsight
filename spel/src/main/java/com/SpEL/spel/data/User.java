package com.SpEL.spel.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("User")
public class User {
    @Value("#{'John Doe'}")
    private String name;
    @Value("#{42}")
    private int age;
    private String language;
    private String country;
    private String timeZone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }
    @Value("#{systemProperties['user.timeZone']}")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public User(
            @Value("#{systemProperties['user.language']}") String language, @Value("#{systemProperties['user.country']}")String country) {
        this.language = language;
        this.country = country;

    }
}
