/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc212_project;

/**
 *
 * @author renadalowais
 */
public class PhotoManager {
LinkedList<Photo> list;

public PhotoManager(){
    list = new LinkedList<Photo>();
}

public LinkedList<Photo> getPhotos(){
    return list;
}

public void addPhoto(Photo p){
    boolean found = false;
    
    //search of photo 
    list.findFirst();
    while (! list.last()){
        if (list.retrieve().path.equals(p.path)){
            found = true; 
            break;
        }
        list.findNext();
    }
    if (list.retrieve().path.equals(p.path))
            found = true; 
     
    //insret photo
    if ( found == true )
        System.out.println("Photo exit!");
    else 
        list.insert(p);
    
}

// Delete a photo
public void deletePhoto(String path){
   
    list.findFirst();
    while (! list.last()){
        if (list.retrieve().path.equals(path)){
           list.remove();
           break;
        }
        list.findNext();
    }
    if (list.retrieve().path.equals(path))
            list.remove();
    else
       System.out.println("Photo not exit!"); 
}
}
