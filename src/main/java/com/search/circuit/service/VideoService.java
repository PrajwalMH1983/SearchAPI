package com.search.circuit.service;

import com.search.circuit.entity.Video;

import java.util.List;

public interface VideoService {
    List<Video> searchVideos(String query);
    Video save(Video video);
    List<Video> getAllVideos();

    void deleteByTitle(String title);
}
