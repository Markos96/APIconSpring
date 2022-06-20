package com.constuyendo.api.apispring.service;

import com.constuyendo.api.apispring.model.Estudiante;
import com.constuyendo.api.apispring.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public void guardar(Estudiante estudiante){
            estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtener()  {
            return estudianteRepository.findAll();
    }

    public Estudiante obtenerUno(Integer id){
        return estudianteRepository.findById(id).get();
    }

    public void actualizar(Estudiante estudiante){
        estudianteRepository.save(estudiante);
    }
    public void eliminar(Integer id){
        estudianteRepository.deleteById(id);
}



}
