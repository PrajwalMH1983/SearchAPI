package com.search.circuit.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;


@Getter
@Setter
@SolrDocument(collection = "first_core")
public class Video {
    @Id
    @Indexed(name = "id", type = "text_general")
    private String id;
    @Indexed(name = "title", type = "text_general")
    private String title;
    @Indexed(name = "description", type = "text_general")
    private String description;
    @Indexed(name = "tags", type = "text_general")
    private String tags;

}
