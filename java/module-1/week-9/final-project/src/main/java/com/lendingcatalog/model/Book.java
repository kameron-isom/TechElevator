package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

public class Book implements CatalogItem {
    private String id;
    private String title;
    private String author;
    private LocalDate publishDate;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book( String title, String author, LocalDate publishDate) {

        this.publishDate = publishDate;
        this.title = title;
        this.author = author;

    }

    public Book(String title, String author, String publishDate){
        this( title, author, LocalDate.parse(publishDate));
    }

    @Override
    public String toString() {
        return "*" + title + System.lineSeparator() +
                "-Id='" + id + System.lineSeparator() +
                "-Title='" + title + System.lineSeparator() +
                "-Author='" + author + System.lineSeparator() +
                "-PublishDate=" + publishDate ;
    }

    @Override
    public boolean matchesName(String searchStr) {
        return title.toLowerCase().contains(searchStr.toLowerCase());

    }
    @Override
    public boolean matchesCreator(String searchStr) {
        return author.toLowerCase().contains(searchStr.toLowerCase());
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return searchYear == publishDate.getYear();
    }

    @Override
    public void registerItem() {
       this.id= UUID.randomUUID().toString();
       try{
           FileStorageService.writeContentsToFile(toString(),"src/main/resources/logs/book.log", true);
       } catch (FileStorageException e){
           System.out.println("Not able to log book");
       }

    }
}
