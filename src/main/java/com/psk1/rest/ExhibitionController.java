package com.psk1.rest;

import com.psk1.entities.Exhibition;
import com.psk1.persistence.ExhibitionsDAO;
import com.psk1.rest.contracts.ExhibitionDTO;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/exhibitions")
public class ExhibitionController {

    @Inject
    @Getter
    @Setter
    private ExhibitionsDAO exhibitionsDAO;


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Exhibition exhibition = exhibitionsDAO.findOne(id);
        if (exhibition == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ExhibitionDTO exhibitionDTO = new ExhibitionDTO();
        exhibitionDTO.setId(exhibition.getId());
        exhibitionDTO.setName(exhibition.getName());

        return Response.ok(exhibitionDTO).build();
    }



    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer exhibitionId,
            ExhibitionDTO exhibitionDTO) {
        try {
            Exhibition existingExhibition = exhibitionsDAO.findOne(exhibitionId);
            if (existingExhibition == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingExhibition.setName(exhibitionDTO.getName());
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createAuthor(ExhibitionDTO exhibitionDTO) {
        Exhibition exhibition = new Exhibition();
        exhibition.setName(exhibitionDTO.getName());

        exhibitionsDAO.persist(exhibition);
        return Response.status(201).entity(exhibition).build();
    }
}
