package com.api.codetech.user.mapping;

import com.api.codetech.shared.mapping.EnhancedModelMapper;
import com.api.codetech.user.domain.model.entity.User;
import com.api.codetech.user.resource.CreateUserResource;
import com.api.codetech.user.resource.UpdateUserResource;
import com.api.codetech.user.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public UserResource toResource(User model){
        return mapper.map(model, UserResource.class);
    }

    public List<UserResource> toResource(List<User>model){
        return mapper.mapList(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource){
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource){
        return mapper.map(resource, User.class);
    }


}
