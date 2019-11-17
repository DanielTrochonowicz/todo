package com.example.todoapp.services;

import com.example.todoapp.models.Models;
import com.example.todoapp.repositories.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    private Repository repository;

    public ModelService(Repository repository) {
        this.repository = repository;
    }

    public List<Models> getModelsList() {
        return repository.findAll();
    }

    public Models addModels(Models models) {
        return repository.save(models);
    }

    public void deleteModels(String title) {
        repository.deleteByTitle(title);
    }

    public void updateModels(Models models) {
        System.out.println(models);

        repository.findByTitle(models.getTitle())
                .ifPresent(m -> {
                    m.setDescription(models.getDescription());
                    m.setDate(models.getDate());
                    m.isStatus(); //sprawdzić czy działa -dodać własnego gettera gdyby nie działało
                    repository.save(m);
                });
    }

    public Models getModelsByTitle(String title) {
        return repository.findByTitle(title).get();
    }
}
