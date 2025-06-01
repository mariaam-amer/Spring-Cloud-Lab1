package iti.jets.user_app.mappers;

import org.mapstruct.Mapper;

import iti.jets.user_app.dto.UserDto;
import iti.jets.user_app.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    public User toEntity(UserDto userDto);
    public UserDto toDto(User user);

}
