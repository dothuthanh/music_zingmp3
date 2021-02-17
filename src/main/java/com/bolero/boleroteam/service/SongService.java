package com.bolero.boleroteam.service;

import com.bolero.boleroteam.model.Song;
import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> findAll();
    Optional<Song> findById(Long id);
    void save(Song song);
    void remove(Long id);
    List<Song> findByLyrics(String lyrics);
    List<Song> findByName(String name);
//    List<Song> findByDateSubmitted();
    List<Song> find3LatestSong();
    List<Song> findAllByOrderByViewsDesc();
}
