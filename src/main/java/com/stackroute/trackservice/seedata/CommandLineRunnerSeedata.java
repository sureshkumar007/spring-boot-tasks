package com.stackroute.trackservice.seedata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerSeedata implements CommandLineRunner
{

    private TrackService trackService;
    @Autowired
    public CommandLineRunnerSeedata(TrackService trackService1)
    {
        this.trackService=trackService1;
    }
    @Override
    public void run(String... args) throws Exception
    {
//        Track track1=new Track(14,"kk","vadepula");
//        Track track2=new Track(15,"pulka","fasak");
//        Track track3=new Track(16,"fasakda","only once");
//        try {
//            trackService.saveTrack(track1);
//            trackService.saveTrack(track2);
//            trackService.saveTrack(track3);
//        }
//        catch(Exception e)
//        {
//            return;
//        }
    }
}
