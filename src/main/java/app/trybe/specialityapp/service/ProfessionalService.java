package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProfessionalService class.
 */
@Service
public class ProfessionalService {

  @Autowired
  private ProfessionalRepository professionalRepository;

  /**
   * Create a new professional.
   */
  public String insert(Professional professional) {
    if (professional.getId() != null) {
      throw new Error("Não é permitido inserir novos registros com ID explícito");
    }
    professionalRepository.save(professional);

    return "Inserido";
  }

  /**
   * Read all professionals.
   */
  public List<Professional> findAll() {
    List<Professional> professionals = professionalRepository.findAll();

    if (professionals.isEmpty()) {
      throw new Error("Nenhum registro foi encontrado!");
    }

    return professionals;
  }

  /**
   * Update a professional.
   */
  public String edit(int id, Professional professional) {
    Optional<Professional> actualProfessional = professionalRepository.findById(id);

    if (actualProfessional.isEmpty()) {
      throw new Error("Não é possível editar, o ID informado não existe");
    }
    actualProfessional.get().setName(professional.getName());
    actualProfessional.get().setSpeciality(professional.getSpeciality());

    return String.format("ID [%d] atualizado", id);
  }

  /**
   * Delete a professional.
   */
  public String delete(int id) {
    Optional<Professional> actualProfessional = professionalRepository.findById(id);

    if (actualProfessional.isEmpty()) {
      throw new Error("Não é possível deletar, o ID informado não existe");
    }
    professionalRepository.deleteById(id);

    return String.format("ID [%d] removido", id);
  }

}