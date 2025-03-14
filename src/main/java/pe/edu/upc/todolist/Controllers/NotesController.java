package pe.edu.upc.todolist.Controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.todolist.Dtos.NotesDTO;
import pe.edu.upc.todolist.Dtos.UserDTO;
import pe.edu.upc.todolist.Entities.Notes;
import pe.edu.upc.todolist.ServiceInterfaces.INotesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
//@SecurityRequirement(name = "javasecurity")
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    private INotesService nts;

    @GetMapping
    public List<NotesDTO> listnotes() {
    return nts.list().stream().map(x->{
        ModelMapper m= new ModelMapper();
        return m.map(x,NotesDTO.class);
    }).collect(Collectors.toList());
    }
    @PostMapping
    public void insert(@RequestBody NotesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notes nt = m.map(dto, Notes.class);
        nts.insert(nt);
    }
    @PutMapping
    public void updatenotes(@RequestBody NotesDTO dto) {
        ModelMapper m= new ModelMapper();
        Notes nt = m.map(dto, Notes.class);
        nts.update(nt);
    }
    @DeleteMapping("/{id}")
    public void deletenotes(@PathVariable("id") Integer id) {nts.delete(id);}

    @GetMapping("/{id}")
    public NotesDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        NotesDTO dto = m.map(nts.listarId(id), NotesDTO.class);
        return dto;
    }
}
