package iti.jets.user_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import iti.jets.user_app.entities.User;

public interface UserRepo extends JpaRepository<User,Long>{
    
}
