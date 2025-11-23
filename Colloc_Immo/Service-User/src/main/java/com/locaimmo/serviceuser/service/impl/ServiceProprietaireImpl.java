package com.locaimmo.serviceuser.service.impl;

import com.locaimmo.serviceuser.domain.entity.Proprietaire;
import com.locaimmo.serviceuser.repository.ProprietaireRepository;
import com.locaimmo.serviceuser.service.IServiceProprietaire;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceProprietaireImpl implements IServiceProprietaire {


    private final ProprietaireRepository proprietaireRepository;

    @Autowired
    public ServiceProprietaireImpl(ProprietaireRepository proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }

    @Override
    public Proprietaire createProprietaire(Proprietaire proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    @Override
    @Transactional(readOnly = true)
    public Proprietaire getProprietaireById(Long id) {
        return proprietaireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Propriétaire non trouvé : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Proprietaire> getAllProprietaires() {
        return proprietaireRepository.findAll();
    }

    @Override
    public Proprietaire updateProprietaire(Proprietaire proprietaire) {
        if (proprietaireRepository.existsById(proprietaire.getId())) {
            Proprietaire oldProprietaire = proprietaireRepository.findById(proprietaire.getId()).get();

            // Exemple de mise à jour — adapte selon les champs existants
            oldProprietaire.setEmail(proprietaire.getEmail());
            oldProprietaire.setPassword(proprietaire.getPassword());
            oldProprietaire.setNom(proprietaire.getNom());
            oldProprietaire.setPrenom(proprietaire.getPrenom());
            oldProprietaire.setTelephone(proprietaire.getTelephone());

            return proprietaireRepository.save(oldProprietaire);
        } else {
            throw new EntityNotFoundException("Propriétaire non trouvé : " + proprietaire.getId());
        }
    }

    @Override
    public void deleteProprietaire(Long id) {
        if (proprietaireRepository.existsById(id)) {
            proprietaireRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Propriétaire non trouvé : " + id);
        }
    }


}
