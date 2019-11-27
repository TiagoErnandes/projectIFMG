package ProjetoBase;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
        * Class Room - a room in an adventure game.
        *
        * This class is part of the "World of Zuul" application.
        * "World of Zuul" is a very simple, text based adventure game.
        *
        * A "Room" represents one location in the scenery of the game.  It is
        * connected to other rooms via exits.  The exits are labelled north,
        * east, south, west.  For each direction, the room stores a reference
        * to the neighboring room, or null if there is no exit in that direction.
        *
        * @author  Michael Kolling and David J. Barnes
        * @version 2008.03.30
        */
public class Room
{
    public String description;
    private HashMap<String, Room> exits;
    private HashSet<Item> content;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */

    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        content = new HashSet<Item>();
    }


    public Room getExit(String direction)
    {
        return exits.get(direction);
    }


    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param vizinha The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExit(String direction, Room vizinha)
    {
        exits.put(direction, vizinha);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }


    public String getExitString()
    {
        String locais = "";
        for(Map.Entry<String, Room> entry: exits.entrySet()){
            locais += entry.getKey()+"  ";
        }
        return locais;
    }

    public String getLongDescription()
    {
        return description + ".\n" + getExitString();
    }

    public void addItem(Item object)
    {
        content.add(object);
    }

    public void removeItem(Item object)
    {
        content.remove(object);
    }



    public Item searchFor(String itemName)
    {
        Item selected = null;

        for(Item next: content) {
            if( itemName.equals(next.getName()) ) {
                selected = next;
                break;
            }
        }
        return selected;
    }

    private String getContents()
    {
        String returnString = "Items:";
        String separator = "";
        for(Item next: content) {
            returnString += separator + " " + next.getName();
            separator = ",";
        }
        return returnString;
    }



    public boolean contains(Item thing)
    {
        return content.contains(thing);
    }

}
