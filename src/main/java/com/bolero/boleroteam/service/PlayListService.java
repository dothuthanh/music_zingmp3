package com.bolero.boleroteam.service;

import com.bolero.boleroteam.model.PlayList;

import java.util.List;
import java.util.Optional;

public interface PlayListService {
    List<PlayList> findAll();
    Optional<PlayList> findById(Long id);
    void save(PlayList playList);
    void remove(Long id);
}
