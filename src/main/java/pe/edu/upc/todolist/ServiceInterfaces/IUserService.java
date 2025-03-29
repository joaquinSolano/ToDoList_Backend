package pe.edu.upc.todolist.ServiceInterfaces;

import pe.edu.upc.todolist.Entities.Users;

import java.util.List;

public interface IUserService {
    public void insert(Users usuario);

    public List<Users> list();

    public void delete(Long idUsuario);

    public Users listarId(Long idUsuario);

    void insertUserAndRole(Users usuario);

}
