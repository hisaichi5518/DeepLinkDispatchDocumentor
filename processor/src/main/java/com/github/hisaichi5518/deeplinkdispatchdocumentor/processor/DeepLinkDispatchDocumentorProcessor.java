package com.github.hisaichi5518.deeplinkdispatchdocumentor.processor;

import com.airbnb.deeplinkdispatch.DeepLink;
import com.github.hisaichi5518.deeplinkdispatchdocumentor.model.Builder;
import com.github.hisaichi5518.deeplinkdispatchdocumentor.model.Documentor;
import com.github.hisaichi5518.deeplinkdispatchdocumentor.model.Logger;
import com.google.auto.service.AutoService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.airbnb.deeplinkdispatch.*"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class DeepLinkDispatchDocumentorProcessor extends AbstractProcessor {
    private static final String DOCUMENT_FILE = "docs/DeepLinkDispatch.DeepLink.md";

    private Logger logger;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.logger = new Logger(processingEnv.getMessager());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Documentor documentor = new Documentor(logger);

        List<Element> elementList = new ArrayList<>();
        roundEnv.getElementsAnnotatedWith(DeepLink.class)
                .stream()
                .filter(element -> element.getKind() == ElementKind.CLASS)
                .forEach(elementList::add);

        if (elementList.size() <= 0) {
            logger.note("Can't find class to use the @DeepLink.");
            return false;
        }

        try {
            documentor.write(new File(DOCUMENT_FILE), new Builder(logger).build(elementList));
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return true;
    }
}
