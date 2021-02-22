package com.wzl.books.controller;

import com.wzl.books.entity.*;
import com.wzl.books.mapper.BookMapper;
import com.wzl.books.mapper.ParamMapper;
import com.wzl.books.mapper.UserBorrowMapper;
import com.wzl.books.mapper.UserMapper;
import com.wzl.books.utils.Md5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {

    //注入依赖
    @Resource
    private UserMapper userMapper;
    @Resource
    private BookMapper bookMapper;
    @Resource
    private ParamMapper paramMapper;
    @Resource
    private UserBorrowMapper userBorrowMapper;

    /**
     * 主页
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model, HttpSession session){
        Param param = paramMapper.findParamByName("views");
        if(param!=null){
            paramMapper.updateParamById(param.getId());
        }else{
            paramMapper.addParam(
                    new Param(UUID.randomUUID().toString().replace("-",""),
                            "views",1)
                    );
        }
        Integer views = paramMapper.findParamByName("views").getNum();
        List<Book> books = bookMapper.findAllBooks();
        Integer sum = 0;
        for (Book b :
                books) {
            sum += b.getNum();
        }
        model.addAttribute("views",views);
        System.out.println("sum:"+sum);
        model.addAttribute("total",sum);
        model.addAttribute("books",books);
        model.addAttribute("num",books.size());
        model.addAttribute("isadmin",session.getAttribute("isadmin"));
        return "index";
    }

    /**
     * 个人主页
     * @param id
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user_profile")
    public String user_profile(@RequestParam("id") String id,Model model,HttpSession session){
        List<Profile> books = bookMapper.findBookListOfUserByUserId(id);
//        System.out.println("user_profile:book="+books.get(0).toString());
        User temp = userMapper.findUserById((String) session.getAttribute("id"));
        System.out.println("user_profile:user="+temp.toString());
        model.addAttribute("user",temp);
        model.addAttribute("books",books);
        return "user_profile";
    }

    /**
     * 用户搜索
     * @param keywords
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user_search")
    public String user_search(String keywords,Model model,HttpSession session){
        System.out.println("user_keywords:"+keywords);
        Param param = paramMapper.findParamByName("views");
        if(param!=null){
            paramMapper.updateParamById(param.getId());
        }else{
            paramMapper.addParam(
                    new Param(UUID.randomUUID().toString().replace("-",""),
                            "views",1)
            );
        }
        Integer views = paramMapper.findParamByName("views").getNum();
        List<Book> books = bookMapper.findAllBooks();
        Integer sum = 0;
        for (Book b :
                books) {
            sum += b.getNum();
        }
        model.addAttribute("views",views);
        List<User> users = userMapper.findUsersByKeywords(keywords);
        model.addAttribute("users",users);
        model.addAttribute("num",users.size());
        model.addAttribute("isadmin",session.getAttribute("isadmin"));
        return "user_search_page";
    }


    /**
     * 添加书籍页
     * @return
     */
    @RequestMapping("/to_add_book")
    public String to_add_book(){
        return "add_book_page";
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @RequestMapping("/add_book")
    public String add_book(Book book){
        book.setId(UUID.randomUUID().toString().replace("-",""));
        bookMapper.addBook(book);
        return "redirect:book";
    }

    /**
     * 主页搜索
     * @param keywords
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/index_search")
    public String index_search(String keywords,Model model,HttpSession session){
        System.out.println("keywords:"+keywords);
        List<Book> books = bookMapper.findBooksByKeywords(keywords);
        Integer sum = 0;
        for (Book b :
                books) {
            sum+=b.getNum();
        }
        model.addAttribute("books",books);
        model.addAttribute("num",books.size());
        model.addAttribute("sum",sum);
        model.addAttribute("isadmin",session.getAttribute("isadmin"));
        return "search_book_index_page";
    }

    /**
     * 书籍管理页搜索
     * @param keywords
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/book_search")
    public String book_search(String keywords,Model model,HttpSession session){
        System.out.println("keywords:"+keywords);
        List<Book> books = bookMapper.findBooksByKeywords(keywords);
        Integer sum = 0;
        for (Book b :
                books) {
            sum+=b.getNum();
        }
        model.addAttribute("books",books);
        model.addAttribute("num",books.size());
        model.addAttribute("sum",sum);
        model.addAttribute("isadmin",session.getAttribute("isadmin"));
        return "search_book_page";
    }

    /**
     * 书籍管理
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/book")
    public String book(Model model,HttpSession session){
        Param param = paramMapper.findParamByName("views");
        if(param!=null){
            paramMapper.updateParamById(param.getId());
        }else{
            paramMapper.addParam(
                    new Param(UUID.randomUUID().toString().replace("-",""),
                            "views",1)
            );
        }
        Integer views = paramMapper.findParamByName("views").getNum();
        List<Book> books = bookMapper.findAllBooks();
        Integer sum = 0;
        for (Book b :
                books) {
            sum += b.getNum();
        }
        System.out.println("sum:"+sum);
        model.addAttribute("total",sum);
        model.addAttribute("books",books);
        model.addAttribute("num",books.size());
        model.addAttribute("views",views);
        model.addAttribute("username",session.getAttribute("username"));
        model.addAttribute("isadmin",session.getAttribute("isadmin"));
        return "book";
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @RequestMapping("/book_delete")
    public String book_delete(@RequestParam("id") String id){
        System.out.println(id);
        Book book = bookMapper.findBookById(id);
        Integer booknum = book.getNum();
        if (booknum>1){
            bookMapper.updateBookNumById(id);
        }else{
            userBorrowMapper.deleteUserBorrowByBookId(id);
            bookMapper.deleteBookById(id);
        }
        return "redirect:book";
    }

    /**
     * 书籍更新页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/to_book_update")
    public String to_book_update(@RequestParam("id") String id,Model model){
        System.out.println(id);
        Book book = bookMapper.findBookById(id);
        model.addAttribute("book",book);
        return "update_book_page";
    }

    /**
     * 书籍详情页
     * @param id
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/to_book_detail")
    public String to_book_detail(@RequestParam("id") String id,Model model,HttpSession session){
        System.out.println(id);
        String uid = (String) session.getAttribute("id");
        UserBorrow userBorrow = userBorrowMapper.findUserBorrowByUidAndBid(uid,id);
        if (userBorrow==null){
            model.addAttribute("isBorrow",0);
        }else{
            model.addAttribute("isBorrow",userBorrow.getIsValid());
        }
        Book book = bookMapper.findBookById(id);
        model.addAttribute("book",book);
        model.addAttribute("username",session.getAttribute("username"));

        return "book_detail";
    }

    /**
     * 借书
     * @param id
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/borrow")
    public String borrow(@RequestParam("id") String id,Model model,HttpSession session){
        String uid = (String)session.getAttribute("id");
        String bid = id;
        Book book = bookMapper.findBookById(id);
        UserBorrow userBorrow = userBorrowMapper.findUserBorrowByUidAndBid(uid,id);
        if (userBorrow==null){
            String tid = UUID.randomUUID().toString().replace("-","");
            userBorrow = new UserBorrow(tid,uid,bid,1,new Date(System.currentTimeMillis()),null);
            userBorrowMapper.addUserBorrow(userBorrow);
        }else{
            userBorrowMapper.updateUserBorrowByIdBorrow(userBorrow.getId(),1);
        }
        UserBorrow userBorrow1 = userBorrowMapper.findUserBorrowByUidAndBid(uid,bid);
        model.addAttribute("book",book);
        model.addAttribute("username",session.getAttribute("username"));
        model.addAttribute("isBorrow",userBorrow1.getIsValid());
        return "book_detail";
    }

    /**
     * 还书
     * @param id
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/return_book")
    public String return_book(@RequestParam("id") String id,Model model,HttpSession session){
        String uid = (String)session.getAttribute("id");
        String bid = id;
        Date returnTime = new Date(System.currentTimeMillis());
        UserBorrow userBorrow = userBorrowMapper.findUserBorrowByUidAndBid(uid,id);
        userBorrowMapper.updateUserBorrowByIdReturn(userBorrow.getId(),0,returnTime);
        UserBorrow userBorrow1 = userBorrowMapper.findUserBorrowByUidAndBid(uid,id);
        System.out.println("return_book:"+userBorrow1.toString());
        Book book = bookMapper.findBookById(id);
        model.addAttribute("book",book);
        model.addAttribute("username",session.getAttribute("username"));
        model.addAttribute("isBorrow",userBorrow1.getIsValid());
        return "book_detail";
    }

    /**
     * 更新书籍
     * @param book
     * @param model
     * @return
     */
    @RequestMapping("/book_update")
    public String book_update(Book book,Model model){
        bookMapper.updateBookById(book);
        return "redirect:book";
    }

    /**
     * 用户管理
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user")
    public String user(Model model,HttpSession session){
        Param param = paramMapper.findParamByName("views");
        if(param!=null){
            paramMapper.updateParamById(param.getId());
        }else{
            paramMapper.addParam(
                    new Param(UUID.randomUUID().toString().replace("-",""),
                            "views",1)
            );
        }
        Integer views = paramMapper.findParamByName("views").getNum();
        List<User> users = userMapper.findAllUsers();
        model.addAttribute("users",users);
        model.addAttribute("num",users.size());
        model.addAttribute("views",views);
        model.addAttribute("username",session.getAttribute("username"));
        model.addAttribute("isadmin",session.getAttribute("isadmin"));
        return "user";
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("/user_delete")
    public String user_delete(@RequestParam("id") String id){
        System.out.println(id);
        userMapper.deleteUserById(id);
        userBorrowMapper.deleteUserBorrowByUserId(id);
        return "redirect:user";
    }

    /**
     * 用户更新页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/to_user_update")
    public String to_user_update(@RequestParam("id")String id,Model model){
        System.out.println("user_update_id:"+id);
        User user = userMapper.findUserById(id);
        model.addAttribute("user",user);
        return "update_user_page";
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping("/update_user")
    public String update_user(User user){
        System.out.println("update_user:"+user.toString());
        userMapper.updateUserById(user);
        return "redirect:user";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:index";
    }

    /**
     * 登录页
     * @return
     */
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    /**
     * 用户登录
     * @param user
     * @param attributes
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, RedirectAttributes attributes,Model model, HttpSession session){
        String username = user.getUsername();
        String password = Md5.getMD5String(user.getPassword());
        User user1 = userMapper.findUserByUsername(username);
//        System.out.println(user1.toString());
        if (user1!=null){
            if (user1.getPassword().equals(password)){
                session.setAttribute("username",username);
                session.setAttribute("isadmin",user1.getIsadmin());
                session.setAttribute("id",user1.getId());
                return "redirect:index";
            }else{
                model.addAttribute("msg2","密码输入错误");
                return "login";
            }
        }else{
            model.addAttribute("msg1","用户名不存在");
            return "login";
        }
    }

    /**
     * 注册页
     * @return
     */
    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }

    /**
     * 用户注册
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(User user,Model model){
        System.out.println(user.toString());
        User user1 = userMapper.findUserByUsername(user.getUsername());
        if (user1!=null){
            model.addAttribute("msg","用户名已存在，请重新输入");
            return "register";
        }
        String pwd = Md5.getMD5String(user.getPassword());
        user.setPassword(pwd);
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setIsadmin(0);
        userMapper.insertUser(user);
        return "redirect:index";
    }


}
