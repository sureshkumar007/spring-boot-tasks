package com.stackroute.trackservice.seedata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import com.stackroute.trackservice.service.TrackService;
import jdk.jfr.DataAmount;
import lombok.Data;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//public class CommandLineRunnerSeedata implements CommandLineRunner
//{
//
//    private TrackService trackService;
//    @Autowired
//    public CommandLineRunnerSeedata(TrackService trackService1)
//    {
//        this.trackService=trackService1;
//    }
//    @Override
//    public void run(String... args) throws Exception
//    {
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
//    }
//}

@Component
@Data
//To create getters and setters for all properties, to override toString(),
// to create equals, canEquals and HashCode.
@ConfigurationProperties(prefix = "track4")
//Used to get the data prefix with track4 and matches with the property name.
public class CommandLineRunnerSeedData implements CommandLineRunner {
    @Qualifier("trackService")
    //Used to particularly mention the bean name.
    private TrackRepository trackRepository;

    @Autowired
    public CommandLineRunnerSeedData(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    private int id;
    private String name;
    private String comments;

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        Track track1 = new Track(Integer.parseInt(environment.getProperty("track3.id")),
                environment.getProperty("track3.name"), environment.getProperty("track3.comments"));
        Track track2 = new Track(id, name, comments);
        trackRepository.save(track1);
        trackRepository.save(track2);
    }
}
