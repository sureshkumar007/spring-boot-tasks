package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface TrackRepository extends JpaRepository<Track, Integer>
public interface TrackRepository extends MongoRepository<Track, Integer>
{
    //Query passing in the repo
   // @Query("select track from Track track where track.name like ?1")
    List<Track> findByName(String name);
//    List<Track> findByName(String name);

}
