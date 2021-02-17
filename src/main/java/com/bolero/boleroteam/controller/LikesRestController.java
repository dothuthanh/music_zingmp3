package com.bolero.boleroteam.controller;

import com.bolero.boleroteam.model.Likes;
import com.bolero.boleroteam.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LikesRestController {
    @Autowired
    private LikesService likesService;

    @GetMapping(value = "likes")
    public ResponseEntity<List<Likes>> getAllLikes(){
        List<Likes> likesList = likesService.findAll();
        return new ResponseEntity<List<Likes>>(likesList, HttpStatus.OK);
    }

    @PostMapping(value = "likes")
    public ResponseEntity<Void> incrementLikes(@RequestBody Likes likes){
        likesService.save(likes);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
