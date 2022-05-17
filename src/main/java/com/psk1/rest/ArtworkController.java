package com.psk1.rest;

import com.psk1.entities.Artwork;
import com.psk1.entities.Author;
import com.psk1.entities.Exhibition;
import com.psk1.persistence.ArtworksDAO;
import com.psk1.persistence.AuthorsDAO;
import com.psk1.persistence.ExhibitionsDAO;
import com.psk1.rest.contracts.ArtworkDTO;
import com.psk1.rest.contracts.AuthorDTO;
import com.psk1.rest.contracts.ExhibitionDTO;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Delete;

import javax.decorator.Delegate;
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
@Path("/artworks")
public class ArtworkController {

    @Inject
    @Getter
    @Setter
    private ArtworksDAO artworksDAO;

    @Inject
    @Getter
    @Setter
    private AuthorsDAO authorsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Artwork artwork = artworksDAO.findOne(id);
        if (artwork == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ArtworkDTO artworkDTO = new ArtworkDTO();
        artworkDTO.setArtworkName(artwork.getName());
        artworkDTO.setExhibitionName(artwork.getExhibition().getName());

        List<AuthorDTO> authorDTOS = new ArrayList<>();

        for (Author author: artwork.getAuthors()) {
            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setId(author.getId());
            authorDTO.setName(author.getName());

            authorDTOS.add(authorDTO);
        }

        artworkDTO.setAuthors(authorDTOS);

        return Response.ok(artworkDTO).build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer artworkId,
            ArtworkDTO artworkDTO) {
        try {
            Artwork existingArtwork = artworksDAO.findOne(artworkId);
            if (existingArtwork == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingArtwork.setName(artworkDTO.getArtworkName());

            List<Author> authors = existingArtwork.getAuthors();

            for(AuthorDTO a : artworkDTO.getAuthors()) {
                Author author = new Author();
                author.setName(a.getName());
                authorsDAO.persist(author);
                authors.add(author);
            }
            existingArtwork.setAuthors(authors);

            artworksDAO.update(existingArtwork);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAuthor(ArtworkDTO artworkDTO) {
        Artwork artwork = new Artwork();
        artwork.setName(artworkDTO.getArtworkName());

        List<Author> authors = new ArrayList<>();

        for(AuthorDTO a : artworkDTO.getAuthors()) {
            Author author = new Author();
            author.setName(a.getName());
            authorsDAO.persist(author);
            authors.add(author);
        }
        artwork.setAuthors(authors);
        artworksDAO.persist(artwork);

        return Response.status(201).entity(artwork).build();
    }

}
