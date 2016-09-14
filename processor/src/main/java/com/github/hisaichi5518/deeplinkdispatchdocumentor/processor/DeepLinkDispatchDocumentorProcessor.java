package com.github.hisaichi5518.deeplinkdispatchdocumentor.processor;

import com.airbnb.deeplinkdispatch.DeepLink;
import com.github.hisaichi5518.deeplinkdispatchdocumentor.model.Documentor;
import com.google.auto.service.AutoService;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.airbnb.deeplinkdispatch.*"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class DeepLinkDispatchDocumentorProcessor extends AbstractProcessor {
    private Filer filer;
    private Messager messager;
    private Elements elements;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        this.filer = processingEnv.getFiler();
        this.elements = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(DeepLink.class)) {
            if (element.getKind() != ElementKind.CLASS) {
                continue;
            }

            // TODO ここにProcessorの処理が入る
            new Documentor().write();
        }
        return true;
    }

}
