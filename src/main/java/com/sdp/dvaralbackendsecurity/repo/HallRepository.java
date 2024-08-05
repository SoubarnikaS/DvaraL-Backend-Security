package com.sdp.dvaralbackendsecurity.repo;


import com.sdp.dvaralbackendsecurity.model.Halls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Halls, Long> {
}
