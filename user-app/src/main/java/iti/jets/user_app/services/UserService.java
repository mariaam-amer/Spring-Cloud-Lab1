package iti.jets.user_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import iti.jets.user_app.dto.OrderDto;
import iti.jets.user_app.dto.UserDto;
import iti.jets.user_app.entities.User;
import iti.jets.user_app.mappers.UserMapper;
import iti.jets.user_app.repos.UserRepo;


@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserMapper userMapper;

    public UserDto createUser(UserDto dto) {
        User user = userMapper.toEntity(dto);
        return userMapper.toDto(userRepo.save(user));
    }

    public UserDto getUserById(Long id) {
        return userRepo.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Object> getUserOrders(Long userId) {
        String url = "http://localhost:8082/orders/users/" + userId;
        return List.of(restTemplate.getForObject(url, Object[].class));
    }


}
