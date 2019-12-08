package com.example.mongotrek;

import lombok.SneakyThrows;
import net.ozwolf.mongo.migrations.MongoTrek;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongotrekConfig {

    @Value(value = "${spring.data.mongodb.uri}")
    String uri;
    @Value(value = "${spring.data.mongodb.database}")
    String database;
    @Value(value = "${application.property.mongotrek.changelog.collection.name}")
    String changeLogName;

    @Value(value = "${application.property.mongotrek.script1.path}")
    String changeLog1Location;
    @Value(value = "${application.property.mongotrek.script2.path}")
    String changeLog2Location;


    @Bean @SneakyThrows
    public MongoTrek store() {
        MongoTrek trek = new MongoTrek(changeLog1Location, uri + database);
        trek.setSchemaVersionCollection(changeLogName);
        trek.migrate();

        trek = new MongoTrek(changeLog2Location, uri + database);
        trek.setSchemaVersionCollection(changeLogName);
        trek.migrate();

        return trek;
    }

}
