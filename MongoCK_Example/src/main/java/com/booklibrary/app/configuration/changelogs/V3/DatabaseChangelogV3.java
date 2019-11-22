package com.booklibrary.app.configuration.changelogs.V3;

import com.booklibrary.app.configuration.changelogs.V3.actions.PresetPenaltyPlansCollection;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
@ChangeLog(order = "001")
public class DatabaseChangelogV3 {

    @ChangeSet(order = "001", id = "id01", author = "Nizami Islamovs", runAlways = true)
    public void penaltyPlansCollection(MongoTemplate repo) {
        System.out.println(">>>>>>>>>>>>>>     STARTING");
        PresetPenaltyPlansCollection.presetPenaltyPlansCollection().forEach(repo::save);
        System.out.println(">>>>>>>>>>>>>>     END");
    }
//
//    @ChangeSet(order = "002", id = "id02", author = "Nizami Islamovs", runAlways = true)
//    public void visitorDataCollection(MongoTemplate repo) {
//        System.out.println(">>>>>>>>>>>>>>     STARTING");
//        PresetVisitorDataCollection.presetVisitorDataCollection().forEach(repo::save);
//        System.out.println(">>>>>>>>>>>>>>     END");
//    }
}
