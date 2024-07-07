package com.search.circuit.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = "com.search.circuit.repository")
@ComponentScan
public class SolrConfiguration {
    @Autowired
    private Environment env;

    @Bean
    public SolrClient solrClient() {
        String solrHost = env.getProperty("spring.data.solr.host");
        return new HttpSolrClient.Builder(solrHost).build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }
}
