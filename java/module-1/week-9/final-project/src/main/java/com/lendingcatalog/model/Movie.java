package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.time.LocalDate;
import java.util.UUID;

public class Movie implements CatalogItem {
    private String id;
    private String name;
    private LocalDate releaseDate;
    private String director;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director= director;
        this.releaseDate = releaseDate;
    }

    public Movie(String name, String director, String releaseDate){
        this(name, director, LocalDate.parse(releaseDate));
    }


    @Override
    public String toString() {
        return "*"+  name + System.lineSeparator()+
                "-Id='" + id + System.lineSeparator() +
                "-Name='" + name + System.lineSeparator()+
                "-ReleaseDate=" + releaseDate + System.lineSeparator()+
                "-Director='" + director ;
    }

    @Override
    public boolean matchesName(String searchStr){
        if(name.toLowerCase().contains(searchStr.toLowerCase())){
            return true;
        }
        return false;
    }
    @Override
    public boolean matchesCreator(String searchStr){
        if (director.contains(searchStr)){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        if(searchYear == getReleaseDate().getYear()){
            return true;
        }
        return false;
    }

    @Override
    public void registerItem() {
        this.id = UUID.randomUUID().toString();
        try{
            FileStorageService.writeContentsToFile(toString(),"src/main/resources/logs/move.log", true);
        } catch (FileStorageException e){
            System.out.println("Not able to log movie");
        }
    }
    }
