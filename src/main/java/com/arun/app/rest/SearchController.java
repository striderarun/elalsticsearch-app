package com.arun.app.rest;

import com.arun.app.beans.Book;
import com.arun.app.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services/books", method = RequestMethod.POST)
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void indexBook(@RequestBody Book book) {
        searchService.indexBook(book);
    }

    @RequestMapping(value = "/author/{author}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void indexBook(@PathVariable String author, @PageableDefault Pageable pageable) {
        searchService.findByAuthor(author, pageable);
    }

}
