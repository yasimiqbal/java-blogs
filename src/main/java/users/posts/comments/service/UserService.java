package users.posts.comments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import users.posts.comments.entity.Address;
import users.posts.comments.entity.User;
import users.posts.comments.entity.UserProfile;
import users.posts.comments.reporsitory.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<String> saveUser(User request) {
        try {
            User user = userRequestArray(request);
            userRepository.save(user);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("no record inserted", HttpStatus.BAD_REQUEST);
        }
    }

    private User userRequestArray(User request) {
        User user = new User();
        user.setUsername(request.getUsername());

        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(request.getUserProfile().getFirstName());
        userProfile.setLastName(request.getUserProfile().getLastName());
        userProfile.setEmail(request.getUserProfile().getEmail());
        userProfile.setPhoneNumber(request.getUserProfile().getPhoneNumber());

        Address address = new Address();
        address.setCity(request.getAddress().getCity());
        address.setCountry(request.getAddress().getCountry());
        address.setZipCode(request.getAddress().getZipCode());
        address.setState(request.getAddress().getState());


        user.setUserProfile(userProfile);
        userProfile.setUser(user);

        user.setAddress(address);
        address.setUser(user);

        return user;
    }


    public ResponseEntity<Optional<User>> getUserById(Long id) {
        try {
            return new ResponseEntity<>(Optional.of(userRepository.findById(id).get()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
        }
    }
}
