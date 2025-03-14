package pe.edu.upc.todolist.ServiceInterfaces;

import pe.edu.upc.todolist.Entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Long idRol);

    public Role listarId(Long idRol);
}
