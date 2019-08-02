package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

public interface TrackService
{
    public Track save(Track track);
    public Track getById(int id);
    public Track getAllTrackes();
    public Track deleteTrackById(int id);
    public Track updateTrack();

}
