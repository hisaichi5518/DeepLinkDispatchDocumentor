package com.github.hisaichi5518.deeplinkdispatchdocumentor.model;

import com.airbnb.deeplinkdispatch.DeepLink;

import java.util.List;

import javax.lang.model.element.Element;

public class Builder {
    private final Logger logger;

    public Builder(Logger logger) {
        this.logger = logger;
    }

    public String build(List<Element> elementList) {
        logger.note("Building DeepLink documentation.");

        StringBuilder result = new StringBuilder();
        result.append("# DeepLinkDispatch.DeepLink\n\n");

        for (Element element : elementList) {
            DeepLink deepLink = element.getAnnotation(DeepLink.class);

            result.append("# ").append(element.getSimpleName()).append("\n")
                    .append("```\n")
                    .append(joinDeepLinks(deepLink.value()))
                    .append("```\n");
        }

        return result.toString();
    }

    private String joinDeepLinks(String[] deepLinks) {
        StringBuilder builder = new StringBuilder();
        for (String deepLink : deepLinks) {
            builder.append(deepLink).append("\n");
        }

        return builder.toString();
    }


}
