package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService
{

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public Track getTrackById(int id) throws TrackNotFoundException;
    public List<Track> getAllTracks();
   public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException;
//public Track deleteTrackById(int id) throws TrackNotFoundException;
    public Track updateTrack(int id, Track track) throws TrackNotFoundException;
    public List<Track> getByName(String name) throws TrackNotFoundException;

}
