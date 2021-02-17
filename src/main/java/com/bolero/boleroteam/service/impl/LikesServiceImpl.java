package com.bolero.boleroteam.service.impl;

import com.bolero.boleroteam.model.Likes;
import com.bolero.boleroteam.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesService likesService;

    @Override
    public List<Likes> findAll() {
        return likesService.findAll();
    }

    @Override
    public Optional<Likes> findById(Long id) {
        return likesService.findById(id);
    }

    @Override
    public void save(Likes likes) {
        likesService.save(likes);
    }

    @Override
    public void remove(Long id) {
        likesService.remove(id);
    }
}
