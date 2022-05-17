package com.psk1.persistence;

import com.psk1.entities.Author;
import com.psk1.interceptors.LoggedInvocation;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@ViewScoped
@Named
public class UpdateAuthorDetails implements Serializable {

    private Author author;

    @Inject
    private AuthorsDAO authorsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateAuthorDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer authorId = Integer.parseInt(requestParameters.get("authorId"));
        this.author = authorsDAO.findOne(authorId);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @LoggedInvocation
    public String updateAuthorName() {
        try{
            authorsDAO.update(this.author);
        } catch (OptimisticLockException e) {
            return "/authorDetails.xhtml?faces-redirect=true&authorId=" + this.author.getId() + "&error=optimistic-lock-exception";
        }
        return "index.xhtml";
    }
}
