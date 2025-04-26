/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csc212_project;

/**
 *
 * @author renadalowais
 */
public class AlbumInvert {
// Constructor
    String name;
    String condition;
    InvIndexPhotoManager manager;
    
    
    public AlbumInvert(String Name, String Condition, InvIndexPhotoManager Manager){
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
    public InvIndexPhotoManager getManager(){
        return manager;
    }
    
    public boolean photoFound(LinkedList<Photo> list , Photo p) {
    if (list.empty()) 
        return false;
    list.findFirst();
    while (true) {
        if (list.retrieve().path.equals(p.path))
            return true;
        if(!list.last())
            list.findNext();
        else 
            break;
    }
    return false;
    }

    public LinkedList<Photo> AllPhoto_tag (String tag) {
       
        LinkedList<Photo> photos = new LinkedList<Photo>();
        boolean found = manager.getPhotos().findKey1(tag);
        if (found) 
            photos = manager.getPhotos().retrieve();
            
        return photos;
    }
    
    public LinkedList<Photo> Common (LinkedList<Photo> list1, LinkedList<Photo> list2) {
    LinkedList<Photo> result = new LinkedList<Photo>();
    
    if (list1.empty() || list2.empty())
        return result;
    list1.findFirst();
    
    while (true) {
        boolean found = photoFound(result, list1.retrieve());
        if (!found){ // not found in result
        list2.findFirst();    
        while (true) {
            if (list2.retrieve().path.equals(list1.retrieve().path)) {
                result.insert(list1.retrieve());
                break;
            }
            if (!list2.last())
                list2.findNext();
            else
                break;
        } // end inner while for B
        }// end if not found
        if (list1.last())
            list1.findNext();
        else
            break;
    }
    return result;
}

    
    
    // Return all photos that satisfy the album condition
public LinkedList<Photo> getPhotos() {
    LinkedList<Photo> result = new LinkedList<Photo>();
    
    if (condition == null) 
        return result;
    
    if (condition.equals("")) 
        return manager.photos;
    
    String conditionList[] = condition.split("AND");
    for (int i = 0; i < conditionList.length; i++) {
        conditionList[i] = conditionList[i].trim();
    }
    
    LinkedList<Photo> list1 = AllPhoto_tag(conditionList[0]);

    for (int i = 1; i < conditionList.length; i++) {
        System.out.println("a[" + i + "]=" + conditionList[i]);
        LinkedList<Photo> list2 = AllPhoto_tag(conditionList[i]);
        list1 = Common(list1, list2);
    }
    return list1;
}




    // Return the number of tag comparisons used to find all photos of the album
    public int getNbComps(){
        return manager.index.count;
    }
    }
