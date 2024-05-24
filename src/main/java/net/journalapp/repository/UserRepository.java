package net.journalapp.repository;

import net.journalapp.entity.UserEntity;
import net.journalapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByUserName(String userName);
}
