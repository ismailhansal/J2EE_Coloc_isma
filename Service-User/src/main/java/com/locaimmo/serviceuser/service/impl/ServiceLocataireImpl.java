package com.locaimmo.serviceuser.service.impl;

import com.locaimmo.serviceuser.domain.entity.Locataire;
import com.locaimmo.serviceuser.repository.LocataireRepository;
import com.locaimmo.serviceuser.service.IServiceLocataire;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceLocataireImpl implements IServiceLocataire {


    private final LocataireRepository locataireRepository;

    @Autowired
    public ServiceLocataireImpl(LocataireRepository locataireRepository) {
        this.locataireRepository = locataireRepository;
    }

    @Override
    public Locataire createLocataire(Locataire locataire) {
        return locataireRepository.save(locataire);
    }

    @Override
    @Transactional(readOnly = true)
    public Locataire getLocataireById(Long id) {
        return locataireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Locataire non trouvé : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Locataire> getAllLocataires() {
        return locataireRepository.findAll();
    }

    @Override
    public Locataire updateLocataire(Locataire locataire) {
        Locataire oldLocataire = locataireRepository.findById(locataire.getId())
                .orElseThrow(() -> new EntityNotFoundException("Locataire non trouvé : " + locataire.getId()));

        // Exemple de mise à jour des champs
        oldLocataire.setEmail(locataire.getEmail());
        oldLocataire.setPassword(locataire.getPassword());
        oldLocataire.setNom(locataire.getNom());
        oldLocataire.setPrenom(locataire.getPrenom());
        oldLocataire.setTelephone(locataire.getTelephone());
        // ajoute ici d'autres champs spécifiques au locataire si nécessaires

        return locataireRepository.save(oldLocataire);
    }

    @Override
    public void deleteLocataire(Long id) {
        if (locataireRepository.existsById(id)) {
            locataireRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Locataire non trouvé : " + id);
        }
    }


}
