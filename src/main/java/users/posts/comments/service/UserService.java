package users.posts.comments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.posts.comments.entity.Address;
import users.posts.comments.entity.User;
import users.posts.comments.entity.UserProfile;
import users.posts.comments.reporsitory.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public String saveUser(User request) {
        User user = userRequestArray(request);
        userRepository.save(user);
        return "success";
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
}
