package com.api.codetech.user.domain.service;

import com.api.codetech.shared.domain.valueObjects.FullName;
import com.api.codetech.user.domain.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long userId);
    User getByEmail(String email);
    List<User> getByFullName(FullName fullName);
    User create(User user);
    User update(Long userId, User user);
    User delete(Long userId);
}
