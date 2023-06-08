package com.api.codetech.user.domain.persistence;

import com.api.codetech.shared.domain.valueObjects.FullName;
import com.api.codetech.user.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);
    List<User>findByFullName(FullName fullName);

}
