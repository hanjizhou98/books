package com.wzl.books.mapper;

import com.wzl.books.entity.UserBorrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Mapper
@Repository
public interface UserBorrowMapper {

    void addUserBorrow(UserBorrow userBorrow);

    UserBorrow findUserBorrowByUidAndBid(String uid,String bid);

    void updateUserBorrowByIdBorrow(@Param("id") String id,@Param("num") Integer num);

    void updateUserBorrowByIdReturn(@Param("id") String id, @Param("num") Integer num, @Param("returnTime")Date returnTime);

    void deleteUserBorrowById(String id);

    void deleteUserBorrowByBookId(String id);

    void deleteUserBorrowByUserId(String id);

}
