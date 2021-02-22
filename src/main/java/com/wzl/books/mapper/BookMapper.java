package com.wzl.books.mapper;

import com.wzl.books.entity.Book;
import com.wzl.books.entity.Profile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    List<Book> findAllBooks();

    Book findBookById(String id);

    Book findBookByName(String name);

    List<Book> findBooksByKeywords(String keywords);

    void addBook(Book book);

    void deleteBookById(String id);

    void updateBookById(Book book);

    void updateBookNumById(String id);

    List<Profile> findBookListOfUserByUserId(String id);
}
