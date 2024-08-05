package com.sdp.dvaralbackendsecurity.repo;

import com.sdp.dvaralbackendsecurity.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Long> {
}
