package com.locaimmo.serviceuser.service;

import com.locaimmo.serviceuser.domain.entity.Proprietaire;
import java.util.List;

public interface IServiceProprietaire {


    Proprietaire createProprietaire(Proprietaire proprietaire);

    Proprietaire getProprietaireById(Long id);

    List<Proprietaire> getAllProprietaires();

    Proprietaire updateProprietaire(Proprietaire proprietaire);

    void deleteProprietaire(Long id);


}
