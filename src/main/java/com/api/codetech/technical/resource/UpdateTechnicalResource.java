package com.api.codetech.technical.resource;

import com.api.codetech.shared.domain.valueObjects.FullName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
public class UpdateTechnicalResource {

    @Embedded
    private FullName fullName;

    @NotNull
    @NotBlank
    @Size(max = 8)
    private String dni;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=8, max = 20)
    private String password;

    @NotNull
    private String profilePictureUrl;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String address;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String phone;

    @NotNull
    private Date birthdayDate;

    @NotNull
    private Float score;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String aboutMe;
}
