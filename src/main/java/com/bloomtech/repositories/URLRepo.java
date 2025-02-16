package com.bloomtech.repositories;

import com.bloomtech.entities.URLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepo extends JpaRepository<URLEntity, Long> {

    public URLEntity findByShortId(String shortId);

}
