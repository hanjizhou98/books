package com.wzl.books.test;

import com.wzl.books.entity.Book;
import com.wzl.books.mapper.BookMapper;
import com.wzl.books.utils.RandomName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
public class TestBook {

    @Autowired(required = false)
    private BookMapper bookMapper;

    /*
        private String id;
        private String name;
        private String author;
        private Date publishTime;
        private Date registerTime;
        private Integer num;
        */
    @Test
    public void test2(){
        for (int i = 0; i < 10; i++) {
            String id = UUID.randomUUID().toString().replace("-","");
            String[] ns = RandomName.getBookNameAndAuthor(i);
            Date publishTime = new Date(System.currentTimeMillis());
            Date registerTime = new Date(System.currentTimeMillis());
            Integer num = new Random().nextInt(100)+1;
            String type = RandomName.getRandomType();
            Book book1 = new Book(id,ns[0],ns[1],publishTime,registerTime,num,type);
            bookMapper.addBook(book1);
        }
    }

    @Test
    public void test1(){
        String root = "C:\\Users\\zhou\\Desktop\\";
        String out = "xm.txt";
        ArrayList<String> names = new ArrayList<>();
        try {
            File f = new File(root + out);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            System.out.println("Reading file using Buffered Reader");
            String s = "";
            while ((readLine = b.readLine()) != null) {
                if (readLine.trim().length()!=0){
                    s+=readLine+"\n";
                }
            }
            FileWriter fileWriter = new FileWriter(new File(root+out));
            fileWriter.write(s);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(names.toString());
    }


}
