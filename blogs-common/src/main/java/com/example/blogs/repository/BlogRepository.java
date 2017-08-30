package com.example.blogs.repository;

import com.example.blogs.model.Blog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Blog 存储库.
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, String> {
}
