package com.stackroute.trackservice.controller;


import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
//Used to map web request into specific classes or methods.
public class TrackController {

    private TrackService trackService;

    @Autowired
    //Used to inject the dependency automatically.
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    //Used to map the request and requestmethod into specific method.
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException
    {

            Track savedTrack = trackService.saveTrack(track);
            //http status displayed the created page
            return new ResponseEntity<>(savedTrack, HttpStatus.CREATED);


        }


    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException
    {

            //Used to extract the data from query parameter.
            //Returns the User object as the response for the given request.
            Track retrievedTrack = trackService.getTrackById(id);
            return new ResponseEntity<>(retrievedTrack, HttpStatus.OK);
        }


    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() throws Exception{

            List<Track> trackList = trackService.getAllTracks();
            return new ResponseEntity<>(trackList, HttpStatus.OK);



    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable("id") int id) throws TrackNotFoundException
    {

           Optional<Track> optionalTrack = trackService.deleteTrackById(id);
           return new ResponseEntity<>(optionalTrack, HttpStatus.OK);



    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateTrackById(@PathVariable int id, @RequestBody Track track) throws TrackNotFoundException
    {

            Track updatedTrack = trackService.updateTrack(id, track);
            return new ResponseEntity<>(updatedTrack, HttpStatus.OK);




    }

    @GetMapping("tracks/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) throws TrackNotFoundException
    {

            List<Track> track=trackService.getByName(name);
            return new ResponseEntity<>(track,HttpStatus.OK);



    }
}

