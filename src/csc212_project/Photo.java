/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc212_project;

/**
 *
 * @author renadalowais
 */
public class Photo {
    public String path ;
    public LinkedList<String> tags ;

    public Photo(String Path, LinkedList<String> Tags){
        path = Path;
        tags = Tags;
    }

    public String getPath(){
        return path;
    }
    public LinkedList<String> getTags(){
        return tags;
    }
    }