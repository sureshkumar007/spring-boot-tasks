package com.stackroute.trackservice.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.trackservice.controller.TrackController;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackRepositoryTest {
    @Autowired
    private TrackRepository trackRepository;
   private Track track;


   //Before Starting of the test case
    @Before
    public void setUp() {
        track = new Track();
        track.setId(10);
        track.setName("John");
        track.setComments("bale bale");


    }

    @After
    public void tearDown() {

        //TrackRepository is assigned to null
        trackRepository=null;
    }


    @Test
    public void givenMethodSaveTheTrack()
    {
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(10, fetchUser.getId());

    }

    @Test
    public void givenMethodNotEqualsTogivenInput()
    {
        Track testUser = new Track(22,"welcome","hellooooooooo");
        trackRepository.save(track);
        Track fetchUser = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testUser,track);
    }

    @Test
    public void givenMethodShouldSaveTheTrack() {
        Track u = new Track(10, "harry", "piiii");
        Track u1 = new Track(103, "welcome", "hjjjjj");
        trackRepository.save(u);
        trackRepository.save(u1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("dj", list.get(0).getName());
    }
    @Test
    public void givenMethodShouldReturnTheAllTrack()
    {
        Track track1=new Track(10,"vadipula","welcome");
        Track track2 = new Track(103, "welcome", "hjjjjj");
        trackRepository.save(track1);
        trackRepository.save(track2);
        List<Track> list1=new ArrayList<>();

            list1.add(track1);
            list1.add(track2);

            Assert.assertEquals(list1,list1);
    }

    @Test
    public void givenTrackAndIdShouldReturnTheTrack() {
        Track testTrack = new Track(110,"oh baby","Intro song");
        trackRepository.save(testTrack);
        assertEquals(testTrack, trackRepository.findById(testTrack.getId()).get());
    }




    }


