package models;

import java.util.Map;

public class ContactList {

    private User owner;
    private String name;

    public final Map<String, String> contacts;

    public ContactList(User owner, Map<String, String> contacts) {
        this.owner = owner;
        this.contacts = contacts;
    }

    public User getOwner() {
        return owner;
    }

    public Map<String, String> getContacts() {
        return contacts;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactList that = (ContactList) o;

        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return contacts != null ? contacts.equals(that.contacts) : that.contacts == null;

    }

    @Override
    public int hashCode() {
        int result = owner != null ? owner.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactList{" +
                "owner=" + owner.toString() +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
