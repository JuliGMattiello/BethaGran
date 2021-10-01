package com.betha.exemplo.exemplo.repository;

import com.betha.exemplo.exemplo.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
