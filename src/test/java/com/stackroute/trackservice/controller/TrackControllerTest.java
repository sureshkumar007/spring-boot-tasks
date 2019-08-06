package com.stackroute.trackservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.GlobalException;
import com.stackroute.trackservice.exceptions.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@WebMvcTest
public class TrackControllerTest {
        @Autowired
        private MockMvc mockMvc;
        private Track track;
        @MockBean
        private TrackService trackService;
        @InjectMocks
        private TrackController trackController;

        private List<Track> list =null;
    private Object TrackController;

    @Before
        public void setUp(){

            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(trackController).setControllerAdvice(new GlobalException()).build();
            track = new Track();
            track.setId(26);
            track.setComments("Jonny");
            track.setName("dj");

            list = new ArrayList();

            list.add(track);
        }

        @Test
        public void saveUser() throws Exception
        {
            when(trackService.saveTrack(any())).thenReturn(track);
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/track")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andDo(MockMvcResultHandlers.print());

         }
         @Test
         public void getTrackByIdreturningId() throws TrackNotFoundException,Exception
         {
             when(trackService.getTrackById(anyInt())).thenReturn(track);
             mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/26")
               .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                    .andExpect(MockMvcResultMatchers.status().isFound())
                 .andDo(MockMvcResultHandlers.print());
         }
    @Test
    public void returningGetAllTracksByid() throws Exception
    {
        when(trackService.getTrackById(anyInt())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void givenIdDeleteinTrack() throws TrackNotFoundException, Exception
    {
        when(trackService.getTrackById(anyInt())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/26")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void givenIdUpdateTrackinTrack() throws TrackNotFoundException, Exception
    {
        when(trackService.getTrackById(anyInt())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/26")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void givenIdgetByName() throws TrackNotFoundException, Exception
    {
        when(trackService.getTrackById(anyInt())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/track/")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
    }


//        @Test
//        public void saveUserFailure() throws Exception {
//            when(userService.saveUser(any())).thenThrow(UserAlreadyExistException.class);
//            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/userservice")
//                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                    .andExpect(MockMvcResultMatchers.status().isConflict())
//                    .andDo(MockMvcResultHandlers.print());
//        }
//
//        @Test
//        public void getAllUser() throws Exception {
//            when(userService.getAllUser()).thenReturn(list);
//            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/userservice")
//                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
//                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andDo(MockMvcResultHandlers.print());
//
//        }
//
//
        private static String asJsonString(final Object obj)
        {
            try{
                return new ObjectMapper().writeValueAsString(obj);

            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }










    }

