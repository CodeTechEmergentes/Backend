package com.api.codetech.user.mapping;

import com.api.codetech.shared.mapping.EnhancedModelMapper;
import com.api.codetech.user.domain.model.entity.Review;
import com.api.codetech.user.resource.CreateReviewResource;
import com.api.codetech.user.resource.ReviewResource;
import com.api.codetech.user.resource.UpdateReviewResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ReviewMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper mapper;

    //Object Mapping
    public ReviewResource toResource(Review model){
        return mapper.map(model, ReviewResource.class);
    }

    public List<ReviewResource> toResource(List<Review> model){
        return mapper.mapList(model, ReviewResource.class);
    }

    public Review toModel(CreateReviewResource resource){
        return mapper.map(resource, Review.class);
    }

    public Review toModel(UpdateReviewResource resource){
        return mapper.map(resource, Review.class);
    }

}

