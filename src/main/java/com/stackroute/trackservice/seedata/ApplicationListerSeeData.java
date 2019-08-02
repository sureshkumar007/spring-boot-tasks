package com.stackroute.trackservice.seedata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ApplicationListerSeeData implements ApplicationListener<ContextRefreshedEvent>
{
    private TrackService trackService;
    @Autowired
    public ApplicationListerSeeData(TrackService trackService)
    {
        this.trackService=trackService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        Track track1=new Track(11,"dj","vadepula");
        Track track2=new Track(12,"ak","fasak");
        Track track3=new Track(13,"pk","only once");
        try {
            trackService.saveTrack(track1);
            trackService.saveTrack(track2);
            trackService.saveTrack(track3);
        }
        catch(Exception e)
        {
            return;
        }

    }

}
