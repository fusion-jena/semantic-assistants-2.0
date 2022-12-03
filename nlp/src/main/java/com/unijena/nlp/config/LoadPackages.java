package com.unijena.nlp.config;

import gate.CorpusController;
import gate.Gate;
import gate.util.GateException;
import gate.util.persistence.PersistenceManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class LoadPackages {
    @Value("${application.path.to.annie}")
    public String PATH_TO_ANNIE;
    @Value("${application.path.to.OT}")
    public String PATH_TO_OT;
    @Value("${application.path.to.bioTagger}")
    public String PATH_TO_BioDivTagger;

    @Bean
    public CorpusController loadBioTagger() throws GateException, IOException {
        Gate.init();
        File folder = new File(PATH_TO_BioDivTagger);
        return (CorpusController) PersistenceManager.loadObjectFromFile(folder);
    }

    @Bean
    public CorpusController loadAnnie() throws GateException, IOException {
        Gate.init();
        File folder = new File(PATH_TO_ANNIE);
        return (CorpusController) PersistenceManager.loadObjectFromFile(folder);
    }

    @Bean
    public CorpusController loadOT() throws GateException, IOException {
        Gate.init();
        File folder = new File(PATH_TO_OT);
        return (CorpusController) PersistenceManager.loadObjectFromFile(folder);
    }
}
