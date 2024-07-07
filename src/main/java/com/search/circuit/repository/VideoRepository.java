package com.search.circuit.repository;

import com.search.circuit.entity.Video;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends SolrCrudRepository<Video, String> {
    @Query("title:*?0* OR description:*?1* OR tags:*?2*")
    List<Video> findByTitleOrDescriptionOrTags(String title, String description, String tags);

    @Query("*:*")
    List<Video> findAllContent();

    List<Video> findByTitle(String title);

}
