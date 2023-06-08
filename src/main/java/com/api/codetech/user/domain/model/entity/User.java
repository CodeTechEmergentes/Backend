package com.api.codetech.user.domain.model.entity;

import com.api.codetech.shared.domain.model.AuditModel;
import com.api.codetech.shared.domain.valueObjects.FullName;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}),
                                           @UniqueConstraint(columnNames = {"dni"})})

public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private FullName fullName;

    @NotNull
    @NotBlank
    @Size(max=8)
    private String dni;

    @NotNull
    @NotBlank
    @Size(max=50)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=8,max=20)
    private String password;

    @NotNull
    private String profilePictureUrl;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    @Size(max=9)
    private String phone;

    @NotNull
    private Date birthdayDate;
}
