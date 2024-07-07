package com.search.circuit.controller;

import com.search.circuit.entity.Video;
import com.search.circuit.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/search")
    public ResponseEntity<?> searchVideos(@RequestParam String query) {
        List<Video> response = videoService.searchVideos(query);
        if(response != null && !response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/addVideo")
    public ResponseEntity<?> addVideo(@RequestBody Video video) {
        Video response = videoService.save(video);
        if(response == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/allVideos")
    public ResponseEntity<?> getAllVideos() {
        List<Video> allVideos = videoService.getAllVideos();
        if(allVideos != null && !allVideos.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(allVideos);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/delete")
    public void deleteByTitle(@RequestParam String title) {
        videoService.deleteByTitle(title);
    }
}
