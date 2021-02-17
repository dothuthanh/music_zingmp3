package com.bolero.boleroteam.controller;

import com.bolero.boleroteam.model.Song;
import com.bolero.boleroteam.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class SongRestController {
    @Autowired
    private SongService songService;

    @PostMapping(value = "/song/create",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createSong(@RequestBody Song song){
        LocalDateTime now = LocalDateTime.now();
        song.setDateSubmitted(now);
        songService.save(song);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/song")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Song>> listSongs(){
        List<Song> songs;
        songs = songService.findAll();
        if (songs.isEmpty()){
            return new ResponseEntity<List<Song>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Song>>(songs,HttpStatus.OK);
        }
    }

    @GetMapping(value = "/song/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable Long id){
        Optional<Song> song = songService.findById(id);
        System.out.println("ok");
        Song song1 = song.get();
        if (song1 == null){
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }else {
            song1.increment();
            songService.save(song1);
            return new ResponseEntity<Song>(song1,HttpStatus.OK);
        }
    }

    @PutMapping("/song/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id,@RequestBody Song song){
        Optional<Song> song1 = songService.findById(id);
        Song song2 = song1.get();
        if (song2 == null){
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }else {
            song2.setName(song.getName());
            song2.setImage(song.getImage());
            song2.setLyrics(song.getLyrics());
            song2.setFileMp3(song.getFileMp3());
            song2.setSinger(song.getSinger());
            song2.setDateSubmitted(LocalDateTime.now());
            song2.setAuthor(song.getAuthor());
            song2.setStyle(song.getStyle());
            songService.save(song2);
            return new ResponseEntity<Song>(song2,HttpStatus.OK);
        }
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<Song> deleteSong(@PathVariable Long id){
        Optional<Song> song = songService.findById(id);
        if (song == null){
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }else {
            songService.remove(id);
            return new ResponseEntity<Song>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/findByLyrics/{lyric}")
    public ResponseEntity<List<Song>> findByLyrics(@PathVariable("lyric") String lyrics){
        List<Song> songs = songService.findByLyrics(lyrics);
        if (songs.isEmpty()){
            return new ResponseEntity<List<Song>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Song>>(songs,HttpStatus.OK);
        }
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Song>> findByName(@PathVariable("name") String name){
        List<Song> songs = songService.findByName(name);
        if (songs.isEmpty()){
            return new ResponseEntity<List<Song>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Song>>(songs,HttpStatus.OK);
        }
    }

    @GetMapping(value ="/api/auth/latest-song")
    public ResponseEntity<List<Song>> findLatestSong(){
        List<Song> songs = songService.find3LatestSong();
        if (songs.isEmpty()){
            return new ResponseEntity<List<Song>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Song>>(songs,HttpStatus.OK);
        }
    }
    @GetMapping(value = "/api/auth/most-views-song") // API lấy danh sách bài hát nhiều lượt nghe nhất
    public ResponseEntity<List<Song>> findMostViewSong(){
        List<Song> songs = songService.findAllByOrderByViewsDesc();
        if (songs.isEmpty()){
            return new ResponseEntity<List<Song>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Song>>(songs,HttpStatus.OK);
        }
    }
}
