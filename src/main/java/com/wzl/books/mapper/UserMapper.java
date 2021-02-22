package com.wzl.books.mapper;

import com.wzl.books.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> findAllUsers();

    List<User> findUsersByKeywords(String keywords);

    User findUserByUsername(String username);

    User findUserById(String id);

    void updateUserById(User user);

    void deleteUserById(String id);

    void insertUser(User user);

}
