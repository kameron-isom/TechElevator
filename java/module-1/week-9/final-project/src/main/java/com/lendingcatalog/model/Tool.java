package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.util.UUID;

public class Tool implements CatalogItem {
    private String id;
    private String type;
    private String manufacturer;
    private int count;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }



    public Tool(String type, String manufacturer, int count) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.count= count;
    }

    public Tool(String type, String manufacturer, String count){
        this(type, manufacturer, Integer.parseInt(count));
    }

    @Override
    public String toString() {
        return "*" + "Tool" +  System.lineSeparator()+
                "-Id='" + id + System.lineSeparator() +
                "-Type='" + type + System.lineSeparator()+
                "-Manufacturer='" + manufacturer + System.lineSeparator() +
                "-Count=" + count ;
    }

    @Override
    public boolean matchesName(String searchStr) {
        if(type.contains(searchStr)){
            return true;
        }
        return false;

    }
    @Override
    public boolean matchesCreator(String searchStr) {
        if (manufacturer.contains(searchStr)){
            return true;
        }
        return false;
    }

    @Override
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {
        this.id= UUID.randomUUID().toString();
        try{
            FileStorageService.writeContentsToFile(toString(),"src/main/resources/logs/tool.log", true);
        } catch (FileStorageException e){
            System.out.println("Not able to log tool");
        }
    }
}

