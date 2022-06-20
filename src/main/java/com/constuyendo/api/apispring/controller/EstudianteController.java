package com.constuyendo.api.apispring.controller;

import com.constuyendo.api.apispring.model.Estudiante;
import com.constuyendo.api.apispring.service.EstudianteService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EstudianteController {


    @GetMapping("/")
    public void index(){
        System.out.println("Hola");
    }
    @Autowired
    private EstudianteService estudianteService;

    @CrossOrigin(origins = "http://localhost:4200")
    @Operation(summary = "Obtiene todos los estudiantes")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "OK",
                    content ={ @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Estudiante.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid",
                content = @Content),
            @ApiResponse(responseCode = "404", description = "Pagina fail",
                content = @Content)
    })

    @GetMapping("api/estudiante")
    public List<Estudiante> obtenerEstudiantes(){
      return estudianteService.obtener();
    }

    @GetMapping("api/estudiante/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Estudiante obtenerUnEstudiante(@PathVariable("id") Integer id){
       return estudianteService.obtenerUno(id);
    }


    @PostMapping("api/estudiante")
    @CrossOrigin(origins = "http://localhost:4200")
    public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante){
        estudianteService.guardar(estudiante);
        return estudiante;
    }

    @PutMapping("api/estudiante")
    @CrossOrigin(origins = "http://localhost:4200")
    public void actualizarEstudiante(@RequestBody Estudiante estudiante){
            estudianteService.actualizar(estudiante);
    }

    @DeleteMapping("api/estudiante/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void borrarEstudiante(@PathVariable("id") Integer id){
        estudianteService.eliminar(id);
    }


}
