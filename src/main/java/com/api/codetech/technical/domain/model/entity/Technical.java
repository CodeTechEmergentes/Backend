package com.api.codetech.technical.domain.model.entity;

import com.api.codetech.shared.domain.model.AuditModel;
import com.api.codetech.shared.domain.valueObjects.FullName;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "technical", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}),
                                                @UniqueConstraint(columnNames = {"dni"})})
public class Technical extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
