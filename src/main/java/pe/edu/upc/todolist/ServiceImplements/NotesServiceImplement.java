package pe.edu.upc.todolist.ServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.todolist.Entities.Notes;
import pe.edu.upc.todolist.Entities.Users;
import pe.edu.upc.todolist.Repositories.INotesRepository;
import pe.edu.upc.todolist.ServiceInterfaces.INotesService;

import java.util.List;
@Service
public class NotesServiceImplement implements INotesService {
    @Autowired
    private INotesRepository ntr;
    @Override
    public List<Notes> list() {
        return ntr.findAll();
    }

    @Override
    public void insert(Notes nt) {
    ntr.save(nt);
    }

    @Override
    public void update(Notes notes) {
    ntr.save(notes);
    }

    @Override
    public void delete(int id) {
    ntr.deleteById(id);
    }

    @Override
    public Notes listarId(int id) {
        return ntr.findById(id).orElse(new Notes());
    }
}
