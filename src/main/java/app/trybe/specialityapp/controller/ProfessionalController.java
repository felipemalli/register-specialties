package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe ProfessionalController.
 */
@Path("/professional")
public class ProfessionalController {

  @Autowired
  private ProfessionalService professionalService;

  /**
   * Create a new professional.
   */
  @POST
  @Path("/add")
  @Consumes("application/json")
  @Produces("application/json")
  public Response insert(Professional professional) {
    try {
      String response = professionalService.insert(professional);

      return Response.status(Status.CREATED).entity(response).build();
    } catch (ApplicationError e) {
      return Response.status(e.getStatus()).entity(e).build();
    }
  }

  /**
   * Read all professionals.
   */
  @GET
  @Path("/all")
  @Produces("application/json")
  public Response findAll() {
    try {
      List<Professional> professionals = professionalService.findAll();

      return Response.status(Status.OK).entity(professionals).build();
    } catch (ApplicationError e) {
      return Response.status(e.getStatus()).entity(e).build();
    }
  }

  /**
   * Update a professional.
   */
  @PUT
  @Path("/edit/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response edit(@PathParam("id") Integer id, Professional professional) {
    try {
      String response = professionalService.edit(id, professional);

      return Response.status(Status.OK).entity(response).build();
    } catch (ApplicationError e) {
      return Response.status(e.getStatus()).entity(e).build();
    }
  }

  /**
   * Delete a professional.
   */
  @DELETE
  @Path("/delete/{id}")
  @Consumes("application/json")
  @Produces("application/json")
  public Response delete(@PathParam("id") Integer id) {
    try {
      String response = professionalService.delete(id);

      return Response.status(Status.OK).entity(response).build();
    } catch (ApplicationError e) {
      return Response.status(e.getStatus()).entity(e).build();
    }
  }
}