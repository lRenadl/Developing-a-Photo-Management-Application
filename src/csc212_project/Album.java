/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc212_project;

/**
 *
 * @author renadalowais
 */
public class Album {
// Constructor
    String name;
    String condition;
    PhotoManager manager;
    int NbComps = 0;
    
    public Album(String Name, String Condition, PhotoManager Manager){
        name = Name;
        condition = Condition;
        manager = Manager;
    }
    // Return the name of the album
    public String getName(){
        return name;
    }
    // Return the condition associated with the album
    public String getCondition(){
        return condition;
    }
    // Return the manager
    public PhotoManager getManager(){
        return manager;
    }
    
    public boolean searchTage ( Photo p , String tag) {
        LinkedList <String> photo_tags = p.getTags();
        
        if (photo_tags.empty())
            return false;
        
        photo_tags.findFirst();
        while (true){
            NbComps++;
           if(photo_tags.retrieve().equals(tag)){
               System.out.println("tag found");
               return true;
           }
               
           
           if (!photo_tags.last())
               photo_tags.findNext();
           else 
               break;
        }
        
        return false;
    }
    
    public boolean CheckCondition (String [] conditionList , Photo p ){
       
        if (conditionList.length == 0)
            return true;
       
        int i = 0 ;
        while ( i < conditionList.length ) {
            if (!searchTage ( p , conditionList[i]))
                return false;
            
            i++;
        }
         return true;
    }
    
    // Return all photos that satisfy the album condition
    public LinkedList<Photo> getPhotos(){
        LinkedList<Photo> Photos = manager.getPhotos();
        LinkedList<Photo> result = new LinkedList<Photo>();
        
        if ( Photos.empty() || condition == null ) return result;
        if ( condition.equals("")) return Photos;
        
        String [] conditionList = condition.split("AND");
        
        for ( int i = 0 ; i < conditionList.length ; i++ )
            conditionList[i] = conditionList[i].trim();
        
        Photos.findFirst();
        
        while( true ){
            if (CheckCondition(conditionList , Photos.retrieve()))
              result.insert(Photos.retrieve());
            
            if (!Photos.last())
               Photos.findNext();
           else 
               break;
        }
      
        return result;
    }

    // Return the number of tag comparisons used to find all photos of the album
    public int getNbComps(){
        return NbComps;
    }
    }
