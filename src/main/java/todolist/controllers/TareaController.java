package todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import todolist.models.Tarea;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TareaController {
    List<Tarea> listaTareas = new ArrayList<>();
    public TareaController(){
        listaTareas.add(new Tarea("Aprender Spring Boot", false));
        listaTareas.add(new Tarea("Utilizar Git", false));
    }
    @GetMapping("/")
    public String mostrarInicio(Model model){
        model.addAttribute("tareas",listaTareas);
        model.addAttribute("nuevaTarea", new Tarea());
        return "index";
    }
    @PostMapping("/agregar")
    public String agregarTarea(@ModelAttribute Tarea nuevaTarea){
        listaTareas.add(nuevaTarea);
        return "redirect:/";
    }
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int indice){
        listaTareas.remove(indice);
        return "redirect:/";
    }
}
