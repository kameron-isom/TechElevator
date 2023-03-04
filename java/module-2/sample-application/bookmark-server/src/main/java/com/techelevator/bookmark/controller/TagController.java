package com.techelevator.bookmark.controller;

import com.techelevator.bookmark.dao.TagDao;
import com.techelevator.bookmark.model.Tag;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * The TagController is a class for handling HTTP Requests related to creating, reading,
 * updating, and deleting Tags.
 *
 * It depends on an instance of a TagDAO for retrieving and storing data. This is provided
 * through dependency injection.
 */
@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping( path = "/tags")
public class TagController {

    private TagDao tagDao;

    public TagController(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<Tag> getAllTags() {
        return tagDao.getAll();
    }

    @RequestMapping( path = "/{tagId}", method = RequestMethod.GET)
    public Tag getTagById(@PathVariable int tagId) {
        Tag tag = tagDao.getById(tagId);
        if (tag == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found");
        }
        return tag;
    }

    @RequestMapping( method = RequestMethod.POST)
    public Tag addTag(@RequestBody Tag newTag) {
        return tagDao.create(newTag);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping( path = "/{tagId}", method = RequestMethod.PUT )
    public Tag updateTag(@PathVariable int tagId, @RequestBody Tag updatedTag) {
        return tagDao.update(updatedTag);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping( path = "/{tagId}", method = RequestMethod.DELETE )
    public void removeTag(@PathVariable int tagId) {
        try {
            tagDao.delete(tagId);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tag is associated to Bookmarks");
        }
    }
}
