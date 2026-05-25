package com.tanuj.Spring.Boot.repository;

import com.tanuj.Spring.Boot.entity.ConfigJournalAppEntity;
import com.tanuj.Spring.Boot.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {


}