package com.psk1.persistence;

import com.psk1.interceptors.LoggedInvocation;
import com.psk1.services.AuthorNameGenerator;
import com.psk1.services.NameGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateAuthorName implements Serializable {

    @Inject
    private NameGenerator nameGenerator;

    private CompletableFuture<String> nameGeneratorTask = null;

    @LoggedInvocation
    public String generateNewName(String name) {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        nameGeneratorTask = CompletableFuture.supplyAsync(() -> nameGenerator.generateName(name));

        return  "/authorDetails.xhtml?faces-redirect=true&authorId=" + requestParameters.get("authorId");
    }

    public boolean isNameGenerationRunning() {
        return nameGeneratorTask != null && !nameGeneratorTask.isDone();
    }

    public String getNameGenerationStatus() throws ExecutionException, InterruptedException {
        if (nameGeneratorTask == null) {
            return null;
        } else if (isNameGenerationRunning()) {
            return "Name generation in progress";
        }
        return "Suggested Name: " + nameGeneratorTask.get();
    }
}
