package com.api.codetech.user.service;

import com.api.codetech.shared.domain.valueObjects.FullName;
import com.api.codetech.shared.exception.ResourceNotFoundException;
import com.api.codetech.shared.exception.ResourceValidationException;
import com.api.codetech.user.domain.model.entity.User;
import com.api.codetech.user.domain.persistence.UserRepository;
import com.api.codetech.user.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final static String ENTITY = "User";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<User> getAll(){return userRepository.findAll();}

    @Override
    public User getById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getByFullName(FullName fullName){
        return userRepository.findByFullName(fullName);
    }

    @Override
    public User create(User request){
        //Set<ConstraintViolation<User>> violations = validator.validate(request);
        //if(!violations.isEmpty())
           // throw new ResourceValidationException(ENTITY, violations);

        try{
            return userRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving user");
        }
    }

    @Override
    public User update(Long userId, User request){
        //Set<ConstraintViolation<User>> violations = validator.validate(request);
        //if(!violations.isEmpty())
           // throw new ResourceValidationException(ENTITY, violations);

        try{
            return userRepository.findById(userId)
                    .map(user->
                            userRepository.save(
                                    user.withFullName(request.getFullName())
                                            .withDni(request.getDni())
                                            .withEmail(request.getEmail())
                                            .withPassword(request.getPassword())
                                            .withProfilePictureUrl(request.getProfilePictureUrl())
                                            .withAddress(request.getAddress())
                                            .withPhone(request.getPhone())
                                            .withBirthdayDate(request.getBirthdayDate())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating user");
        }
    }

    @Override
    public User delete(Long userId){
        return userRepository.findById(userId)
            .map(user-> {
                userRepository.delete(user);
                return user;
            }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
    }

}
