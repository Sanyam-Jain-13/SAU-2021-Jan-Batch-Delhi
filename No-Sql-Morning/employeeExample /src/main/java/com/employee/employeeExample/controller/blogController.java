package com.employee.employeeExample.controller;

import com.employee.employeeExample.model.Blog;
import com.employee.employeeExample.repository.blogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class blogController {

    @Autowired
    blogRepository blogRepository;


    /*
     * @RequestMapping("/") public String index() { return
     * "Welcome to the CRUD application!!"; }
     */

    @PostMapping("/Blog")
    public Blog addBlogPost(@RequestBody Blog newBlog) {

        return blogRepository.save(newBlog);
    }

    @GetMapping("/Blog/{id}")
    public Optional<Blog> getBlog(@PathVariable String id) {
        if (blogRepository.existsById(id)) {
            return blogRepository.findById(id);
        } else
            return Optional.empty();
    }

    @GetMapping("/Blog/author/{author}")
    public List<Blog> getBlogByAuthorName(@PathVariable String author) {

        return blogRepository.findByAuthor(author);
    }

    @GetMapping("/Blog/tag/{tag}")
    public List<Blog> getBlogByTagName(@PathVariable String tag){

//      return  blogRepository.findByTags(tag);
        List<Blog> allBlogs = (List<Blog>) blogRepository.findAll();
            List<Blog> result =  new ArrayList<Blog>();
            for (Blog blog : allBlogs) {
                if(blog.getTags().contains(tag))
                    result.add(blog);
            }
            return result;
    }

    @DeleteMapping("/Blog/topic/{topic}/author/{author}")
    public List<Blog> deleteByAuthorAndTopic(@PathVariable String topic, @PathVariable String author) {
        return blogRepository.deleteByTopicAndAuthor(topic, author);
    }

    @DeleteMapping("/Blog/{id}")
    public void deleteById(@PathVariable String id) {
        blogRepository.deleteById(id);
    }

    /*
     * @PutMapping("/Blog/{idToBeUpdated}") public String updateBlog(@PathVariable
     * String idToBeUpdated, @RequestBody BlogUpdateRequest BlogUpdateRequest) {
     *
     * Optional<Blog> mayBeBlog = blogRepository.findById(idToBeUpdated) .map(Blog
     * –> blogRepository .save(Blog .builder() .id(idToBeUpdated)
     * .topic(BlogUpdateRequest.getTopic()) .tags(BlogUpdateRequest.getTags())
     * .author(Blog.getAuthor()) .date(Blog.getDate()) .build()) ); if
     * (mayBeBlog.isPresent()) { return "Blog Updated"; } else { return
     * "Blog does not exist"; } }
     */

}
