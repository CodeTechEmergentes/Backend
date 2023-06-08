package com.api.codetech.user.resource;

import com.api.codetech.technical.resource.TechnicalResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResource {
    private Long id;
    private String text;
    private Float score;
    private Float magnitude;
    private UserResource user;
    private TechnicalResource technical;
}
