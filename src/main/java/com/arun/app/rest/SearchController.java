package com.arun.app.rest;

import com.arun.app.beans.Book;
import com.arun.app.common.JsonDocConstants;
import com.arun.app.service.SearchService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiHeader;
import org.jsondoc.core.annotation.ApiHeaders;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import java.util.List;

import static com.arun.app.common.JsonDocConstants.AUTHOR_PARAM;
import static com.arun.app.common.JsonDocConstants.AUTHOR_PARAM_DESC;
import static com.arun.app.common.JsonDocConstants.TITLE_PARAM;
import static com.arun.app.common.JsonDocConstants.TITLE_PARAM_DESC;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@RestController
@RequestMapping(value = "/services/books", method = RequestMethod.POST)
@Api(group = JsonDocConstants.BOOKS, name = "Book Services", description = "Methods for indexing and querying books")
@ApiVersion(since = "1.0")
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * Index a new book
     *
     * @param book
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ApiMethod(description = "Indexes a new book", responsestatuscode = "201 - Created")
    @ApiHeaders(headers = {
            @ApiHeader(name = ACCEPT),
            @ApiHeader(name = CONTENT_TYPE)
    })
    @ApiResponseObject
    public void indexBook(@ApiBodyObject @RequestBody Book book) {
        searchService.indexBook(book);
    }

    /**
     * Query for books by author
     *
     * @param author
     * @param pageable
     * @return
     */
    @RequestMapping(value = "/author/{author}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiMethod(description = "Queries books by author", responsestatuscode = "200 - Ok")
    @ApiHeaders(headers = {
            @ApiHeader(name = ACCEPT),
            @ApiHeader(name = CONTENT_TYPE)
    })
    @ApiResponseObject
    public Page<Book> findBooksByAuthors(@ApiPathParam(name = AUTHOR_PARAM, description = AUTHOR_PARAM_DESC) @PathVariable String author, @PageableDefault Pageable pageable) {
        return searchService.findByAuthor(author, pageable);
    }

    /**
     * Query for books by title
     *
     * @param title
     * @return
     */
    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiMethod(description = "Queries books by title", responsestatuscode = "200 - Ok")
    @ApiHeaders(headers = {
            @ApiHeader(name = ACCEPT),
            @ApiHeader(name = CONTENT_TYPE)
    })
    @ApiResponseObject
    public List<Book> findBooksByTitle(@ApiPathParam(name = TITLE_PARAM, description = TITLE_PARAM_DESC) @PathVariable String title) {
        return searchService.findByTitle(title);
    }


}
