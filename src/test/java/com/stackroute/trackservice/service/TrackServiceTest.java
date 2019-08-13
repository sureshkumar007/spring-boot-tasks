package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class TrackServiceTest {
    private Track track;

    //Create a mock for UserRepository
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
   private TrackServiceImpl trackService;
   private List<Track> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setName("Niki");
        track.setId(101);
        track.setComments("vadi pula vadi");
        list = new ArrayList<>();
        list.add(track);
    }

    @After
    public void tearDown()
    {
        trackService=null;
    }
    @Test(expected = TrackAlreadyExistsException.class)
    public void saveUserTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.existsById(track.getId())).thenReturn(true);
        Track savedUser = trackService.saveTrack(track);
    }


    @Test
    public void givenIdShouldReturnTrack() throws TrackNotFoundException {
        when(trackRepository.existsById(track.getId())).thenReturn(true);
        when(trackRepository.findById(track.getId())).thenReturn(Optional.of(track));
        Track savedTrack=trackService.getTrackById(track.getId());
        Assert.assertEquals(track,savedTrack);
    }

    @Test(expected = TrackNotFoundException.class)
    public void givenIdShouldReturnException() throws TrackNotFoundException {
        Track savedTrack = trackService.getTrackById(track.getId());
        trackService.deleteTrackById(track.getId());
        trackService.updateTrack(track.getId(), track);
    }


//    @Test(expected = TrackNotFoundException.class)
//    public void getTrackByIdTest() throws TrackNotFoundException
//    {
//        when(trackRepository.existsById(track.getId())).thenReturn(true);
//        Track track=trackService.getTrackById(22);
//    }


    @Test(expected = TrackNotFoundException.class)
    public void getByNameExceptionid() throws TrackNotFoundException
    {
        when(trackRepository.existsById(track.getId())).thenReturn(true);
        List<Track> savedTrack=trackService.getByName("Nikkkk");
    }


    @Test
    public void getAllUser() {
        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = trackService.getAllTracks();
        Assert.assertEquals(list, userlist);
    }


    @Test(expected = TrackNotFoundException.class)
    public void givenTrackIdShouldReturnException() throws TrackNotFoundException, Exception {
        Track savedTrack = trackService.getTrackById(track.getId());
        //delete track by id
        trackService.deleteTrackById(track.getId());
        //updatetrack
        trackService.updateTrack(track.getId(),track);
    }




}



