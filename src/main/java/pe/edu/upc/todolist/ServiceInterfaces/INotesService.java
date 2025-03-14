package pe.edu.upc.todolist.ServiceInterfaces;

import pe.edu.upc.todolist.Entities.Notes;
import pe.edu.upc.todolist.Entities.Role;

import java.util.List;

public interface INotesService {
    public List<Notes> list();
    public void insert(Notes nt);
    public void update(Notes notes);
    public void delete(int id);
    public Notes listarId(int id);
}
