package net.journalapp.service;

import lombok.extern.slf4j.Slf4j;
import net.journalapp.entity.UserEntity;
import net.journalapp.model.User;
import net.journalapp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    //private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveEntry(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("ADMIN"));
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);
            userRepository.save(userEntity);
            return true;
        }catch (Exception e){
            log.error("hahahhahahha");
            log.warn("hahahhahahha");
            log.info("hahahhahahha");
            log.debug("hahahhahahha");
            log.trace("hahahhahahha");
            /*log.error("Error occurred for {} :", user.getUserName(), e);
            log.warn("Warn occurred for {} :", user.getUserName(), e);
            log.info("Info occurred for {} :", user.getUserName(), e);
            log.debug("Debug occurred for {} :", user.getUserName(), e);
            log.trace("Trace occurred for {} :", user.getUserName(), e);*/

            return false;

        }
    }

    public  void saveUser(User user){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(ObjectId id){
        return userRepository.findById(String.valueOf(id));
    }

    public User findByUserName(String userName){
        UserEntity userEntity = userRepository.findByUserName(userName);
        User user = new User();
        BeanUtils.copyProperties(userEntity, new User());
        return user;
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(String.valueOf(id));
    }
}
