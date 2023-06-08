package com.api.codetech.user.resource;

import com.api.codetech.shared.domain.valueObjects.FullName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class UserResource {
    private Long id;
    private FullName fullName;
    private String dni;
    private String email;
    private String password;
    private String profilePictureUrl;
    private String address;
    private String phone;
    private Date birthdayDate;
}
