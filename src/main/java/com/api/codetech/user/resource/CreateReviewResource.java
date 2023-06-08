package com.api.codetech.user.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateReviewResource {
    @NotNull
    @NotBlank
    private String text;

    @NotNull
    private Float score;

    @NotNull
    private Float magnitude;
}
