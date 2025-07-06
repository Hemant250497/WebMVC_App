package com.tcs.controller;

import com.tcs.entity.Book;
import com.tcs.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookRepository repo;

    @GetMapping("/book")
    public ModelAndView getBookById(@RequestParam("id") Integer id){
        Optional<Book> getById = repo.findById(id);
        System.out.println("Id::"+id);
        ModelAndView mav = new ModelAndView();
        if(getById.isPresent()){
            Book Bookobj = getById.get();
            System.out.println(Bookobj);
            mav.addObject("book",Bookobj);
        }
        mav.setViewName("index");
        return mav;
    }
}
