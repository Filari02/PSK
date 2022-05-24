package com.psk1.rest;

import com.psk1.entities.Artwork;
import com.psk1.entities.Author;
import com.psk1.persistence.ArtworksDAO;
import com.psk1.persistence.AuthorsDAO;
import com.psk1.rest.contracts.ArtworkDTO;
import com.psk1.rest.contracts.AuthorDTO;
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
@Path("/authors")
public class AuthorController {

    @Inject
    @Getter
    @Setter
    private AuthorsDAO authorsDAO;

    @Inject
    @Getter
    @Setter
    private ArtworksDAO artworksDAO;


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Author author = authorsDAO.findOne(id);
        if (author == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());

        List<ArtworkDTO> artworkDTOS = new ArrayList<>();

        for (Artwork artwork: author.getArtworks()) {
            ArtworkDTO artworkDTO = new ArtworkDTO();
            artworkDTO.setId(artwork.getId());
            artworkDTO.setName(artwork.getName());

            artworkDTOS.add(artworkDTO);
        }
        authorDTO.setArtworks(artworkDTOS);

        return Response.ok(authorDTO).build();
    }



    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer authorId,
            AuthorDTO authorDTO) {
        try {
            Author existingAuthor = authorsDAO.findOne(authorId);
            if (existingAuthor == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingAuthor.setName(authorDTO.getName());

            for(ArtworkDTO a : authorDTO.getArtworks()) {
                Artwork artwork = artworksDAO.findOne(a.getId());
                List<Author> authors = artwork.getAuthors();

                if(authors.contains(existingAuthor)) {
                    continue;
                }
                authors.add(existingAuthor);
                artwork.setAuthors(authors);
                artworksDAO.update(artwork);
            }


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
    public Response createAuthor(AuthorDTO authorDTO) {

        Author author = new Author();
        author.setName(authorDTO.getName());

        for(ArtworkDTO a : authorDTO.getArtworks()) {
            Artwork artwork = artworksDAO.findOne(a.getId());
            List<Author> authors = artwork.getAuthors();
            authors.add(author);
            artwork.setAuthors(authors);
            artworksDAO.persist(artwork);
        }

        return Response.status(201).entity(authorDTO).build();
    }
}
