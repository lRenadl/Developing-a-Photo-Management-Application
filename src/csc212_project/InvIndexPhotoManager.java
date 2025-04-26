/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc212_project;

/**
 *
 * @author renadalowais
 */
public class InvIndexPhotoManager {
    BST<LinkedList<Photo>> index;
    LinkedList <Photo> photos;
// Constructor
public InvIndexPhotoManager(){
    index = new BST<LinkedList<Photo>>();
    photos = new LinkedList <Photo> ();
}

// Add a photo
public void addPhoto(Photo p){
    
    if (searchPhoto(photos , p)) {
        System.out.println("Photo Exist");
        return;
    }
    
    photos.insert(p);
    
    LinkedList<String> tags = p.getTags();
    
    tags.findFirst();
    
    while (true){
        String CurrentTag = tags.retrieve();
        boolean Exist = index.findKey(CurrentTag);
        if(!Exist){
            LinkedList<Photo> CurrentPhotos = new LinkedList <Photo> ();
            CurrentPhotos.insert(p);
            index.insert(CurrentTag, CurrentPhotos);
        } else 
             index.retrieve().insert(p);
            
        if (!tags.last())
            tags.findNext();
        else 
            break;
        
    }
}

// Delete a photo
public void deletePhoto(String path){
    LinkedList<String> tags =  removeFromPhotos ( path );
    
    if ( tags == null || tags.empty())
        return;
    
    Photo DeletP = new Photo ( path , tags );
    tags.findFirst();
    
    while (true) {
        if(index.findKey(tags.retrieve())){
          removeFromIndex( index.retrieve() , DeletP )  ;
          if(index.retrieve().empty())
              index.removeKey(tags.retrieve());
        }
        
        if(!tags.last())
            tags.findNext();
        else 
            break;
    }
        //return;
    
    
}

// Return the inverted index of all managed photos
public BST<LinkedList<Photo>> getPhotos(){
    return index;
}

public boolean searchPhoto( LinkedList<Photo> list , Photo p){
    
    if (list.empty()) return false;
    
    list.findFirst();
    
    while (true){
        if(list.retrieve().path.equals(p.path))
            return true;
        
        if (!list.last())
            list.findNext();
        else 
            break;
    }
    
    return false;
}

//Delete photo from tags "BST"
public void removeFromIndex( LinkedList<Photo> list , Photo p){
    if(list.empty())
        return;
    list.findFirst();
    
    while( (!list.empty()) && (!list.last()) ) {
    
        if (list.retrieve().path.equals(p.path))
            list.remove();
        else 
            list.findNext();
}
    if ( (!list.empty()) && list.retrieve().path.equals(p.path))
            list.remove();
}

//Delete photo from linkedlist
public LinkedList<String> removeFromPhotos (String path ){
    
    LinkedList<String> tags = null;
    
    if (photos.empty())
        return null;
    
    photos.findFirst();
    
    while ( true ){
        if (photos.retrieve().path.equals(path)){
            tags = photos.retrieve().tags;
            photos.remove();
            break;
        }
        
        if (!photos.last())
            photos.findNext();
        else
            break;
        
    }
    
    return tags;
    
}

}
