package it.polimi.ingsw.model.personalboard;

import it.polimi.ingsw.model.Resource;
import it.polimi.ingsw.model.ResourceCreator;

import java.util.ArrayList;

public class WarehouseDepots implements ResourceCreator {


    /**
     * is the structure where the Resources are stored
     */
    private final Shelf[] shelves =new Shelf[3];

    public WarehouseDepots(){
        for(int i=0;i<shelves.length;i++)
            shelves[i]=new Shelf(shelves.length-i);
    }

    /**
     * @return the entire structure of Warehouse depots
     */
    public Shelf[] getShelves() {
        return shelves;
    }


    /**
     * @param i is the Shelf level where the player wants to put the Resources
     * @param resources is the list of Resources that have to be added
     * @return the entire structure of Warehouse
     */
    public Shelf addInShelf(int i, ArrayList<Resource> resources) {
        shelves[i].getSlots().addAll(resources);
        return shelves[i];

    }

    /**
     * @param i is the Shelf level where the player wants to put the Resources
     * @param resource is the Resource that has to be added
     * @return the entire structure of Warehouse
     */
    public Shelf addInShelf(int i, Resource resource) {
        shelves[i].getSlots().add(resource);
        return shelves[i];
    }

    /**
     * @return a specific resource and remove it from player's warehouse
     */
    public Resource removeResource(Resource resource) {
        for (Shelf shelf : shelves) {
                for (Resource resource1 : shelf.getResources()) {
                    if (resource == resource1) {
                        shelf.getResources().remove(resource);
                        return resource;
                    }
                }
        }
        return null;
    }

    /**
     * @return all resources that are in Warehouse in every shelf
     */
    @Override
    public ArrayList<Resource> getResources()  {
        ArrayList<Resource> allRes =new ArrayList<>();
        for (Shelf shelf : shelves) {
            allRes.addAll(shelf.getResources());
        }
        return allRes;
    }

    public void clear() {
        for (Shelf shelf : shelves) {
            shelf.removeAllRes();
        }
    }

}
