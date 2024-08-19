package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Rating;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RatingService")
public interface RatingService {

    @PostMapping("/ratings")
    public Rating createRating(Rating rating);

    @GetMapping("/ratings/users/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable String userId);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(Rating rating , @PathVariable String ratingId);

    @DeleteMapping("ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
