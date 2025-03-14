package pe.edu.upc.todolist.Dtos;

import pe.edu.upc.todolist.Entities.Users;

public class NotesDTO {
    private int id;
    private String description;
    private Users user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
