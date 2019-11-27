package ProjetoBase;

/**
 * Escreva a descrição da classe Item aqui.
 *
 * @author (seu nome)
 * @version (número de versão ou data)
 */
public class Item
{
    private String name;
    private String description;
    private int weight;

    /**
     * COnstrutor para objetos da classe Item
     */
    public Item(String name, String description, int weight)
    {
        // initialise instance variables
        this.name = name;
        this.description = description;
        this.weight = weight;
    }


    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }



    public String getName()
    {
        return this.name;
    }



    public void setName(String name)
    {
        this.name = name;
    }


    public int getWeight()
    {
        return weight;
    }
}


