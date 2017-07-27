package com.arun.app.rest;

import com.arun.app.beans.Book;
import com.arun.app.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/getDetails", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void getDetails(@RequestBody Book book) {

    }
}
