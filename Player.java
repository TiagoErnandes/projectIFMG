package ProjetoBase;

/**
 * Escreva a descrição da classe Player aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class Player
{
    private Item mochila;
    private int forca;
    private Room currentRoom;


    /**
     * COnstrutor para objetos da classe Player
     */
    public Player()
    {
        mochila = null;
        forca = 10000; // 10 kg
    }

    public void setLocation(Room room){
        currentRoom = room;
    }

    public Room getLocation()
    {
        return currentRoom;
    }

    public boolean hasItem(String item)
    {
        return (mochila != null && item.equals(mochila.getName()))? true:false;
    }

    public Item onMe()
    {
        return mochila;
    }

    /**
     * Try to pick an object up. Fails if (1) the object is not in the present room,
     * (2) if the player is already carrying something or (3) if the object is too heavy
     *
     * @return boolean success
     */
    public boolean pickUpItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Grab what?");
            return false;
        }

        String itemName = command.getSecondWord();
        if( mochila != null && itemName.equals( mochila.getName() ) ) {
            System.out.println("Uh, you're carrying it already.");
            return false;
        }

        Item thing = currentRoom.searchFor(itemName);
        if( thing == null ) {
            System.out.println("This item isn't in this room!");
            return false;
        }
        if( thing.getWeight() > forca ) {
            System.out.println("This item is too heavy!");
            return false;
        }
        if( mochila != null ) {
            System.out.println("First drop what you're carrying!");
            return false;
        }
        mochila = thing;
        currentRoom.removeItem(thing);

        return true;
    }

    /**
     * Try to drop an object. Fails if (1) the player isn't carrying anything, or
     * (2) if the player is not carrying this object
     *
     * @return boolean success
     */
    public boolean dropItem(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return false;
        }

        String itemName = command.getSecondWord();
        if( mochila == null) {
            System.out.println("Uh, you're not carrying anything.");
            return false;
        }
        if( ! itemName.equals(mochila.getName()) ) {
            System.out.println("You're not carrying this object!");
            return false;
        }
        currentRoom.addItem(mochila);
        mochila = null;

        return true;
    }


}
