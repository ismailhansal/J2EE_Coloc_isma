package com.locaimmo.serviceuser.service;

import com.locaimmo.serviceuser.domain.entity.Locataire;
import java.util.List;

public interface IServiceLocataire {


    Locataire createLocataire(Locataire locataire);

    Locataire getLocataireById(Long id);

    List<Locataire> getAllLocataires();

    Locataire updateLocataire(Locataire locataire);



}
