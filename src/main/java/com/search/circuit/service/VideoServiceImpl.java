package com.search.circuit.service;

import com.search.circuit.entity.Video;
import com.search.circuit.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VideoServiceImpl implements VideoService {

    private static final String SOLR_CORE = "first_core";
    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private SolrTemplate solrTemplate;

    public List<Video> searchVideos(String query) {
        try {
            return videoRepository.findByTitleOrDescriptionOrTags(query, query, query);
        } catch (Exception e){
            log.error("Error while Searching for a Video : {}" , e.getMessage());
            return null;
        }
    }

    @Transactional
    public Video save(Video video) {
        try {
            solrTemplate.saveBean(SOLR_CORE, video, Duration.ZERO);
            solrTemplate.commit(SOLR_CORE);
            return video;
        } catch (Exception e) {
            log.error("Error while Saving a Video : {}" , e.getMessage());
            return null;
        }
    }

    public List<Video> getAllVideos() {
        try {
            return videoRepository.findAllContent();
        } catch (Exception e){
            log.error("Error while Getting all Videos : {}" , e.getMessage());
            return new ArrayList<>();
        }
    }

    @Transactional
    public void deleteByTitle(String title) {
        try {
            List<Video> videos = videoRepository.findByTitle(title);

            for (Video video : videos) {
                solrTemplate.deleteByIds(SOLR_CORE, video.getId());
            }

            solrTemplate.commit(SOLR_CORE);
        } catch (Exception e){
            log.error("Error while Deleting a Video : {}" , e.getMessage());
        }
    }

}
