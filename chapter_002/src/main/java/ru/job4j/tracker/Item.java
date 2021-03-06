package ru.job4j.tracker;

/**
 * @author Misha shirinkin (Misha.shirinkin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {

    private String id;

    private String name;

    private String description;

    private long created;

    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreated() {
        return this.created;
    }

    @Override
    public String toString() {
        return "Заявка{"
                + "id='" + this.id + '\''
                + ", name='" + this.name + '\''
                + ", description='" + this.description + '\''
                + ", created=" + this.created + "}";
    }
}
