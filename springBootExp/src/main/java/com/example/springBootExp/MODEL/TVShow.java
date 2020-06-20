package com.example.springBootExp.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class TVShow {

    private final UUID id;
    private final String name;
    private final String company;
    private final String released;

    public TVShow(@JsonProperty ("id") UUID id,
                  @JsonProperty ("name") String name,
                  @JsonProperty ("company") String company,
                  @JsonProperty ("released") String released){

        this.id = id;
        this.name = name;
        this.company = company;
        this.released = released;

    }

    public String getName() {
        return name;
    }
    public String getCompany() {
        return company;
    }
    public String getReleased() {
        return released;
    }
    public UUID getId() {
        return id;
    }


}
