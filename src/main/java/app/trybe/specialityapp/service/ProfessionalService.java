package app.trybe.specialityapp.service;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfessionalService {

  @Autowired
  private ProfessionalRepository professionalRepository;

  /**
   * Create a new professional.
   */
  public String insert(Professional professional) {
    if (professional.getId() != null) {
      throw new ApplicationError(Response.Status.BAD_REQUEST,
              "Não é permitido inserir novos registros com ID explícito");
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
      throw new ApplicationError(Response.Status.NOT_FOUND,
              "Nenhum registro foi encontrado!");
    }

    return professionals;
  }

  /**
   * Update a professional.
   */
  public String edit(Integer id, Professional professional) {
    Optional<Professional> actualProfessional = professionalRepository.findById(id);

    if (actualProfessional.isEmpty()) {
      throw new ApplicationError(Response.Status.NOT_FOUND,
              "Não é possível editar, o ID informado não existe");
    }
    actualProfessional.get().setName(professional.getName());
    actualProfessional.get().setSpeciality(professional.getSpeciality());

    return String.format("ID [%d] atualizado", id);
  }

  /**
   * Delete a professional.
   */
  public String delete(Integer id) {
    Optional<Professional> actualProfessional = professionalRepository.findById(id);

    if (actualProfessional.isEmpty()) {
      throw new ApplicationError(Response.Status.NOT_FOUND,
              "Não é possível deletar, o ID informado não existe");
    }
    professionalRepository.deleteById(id);

    return String.format("ID [%d] removido", id);
  }

}