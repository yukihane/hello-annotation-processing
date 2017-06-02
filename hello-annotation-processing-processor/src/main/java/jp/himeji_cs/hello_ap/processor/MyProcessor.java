package jp.himeji_cs.hello_ap.processor;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

public class MyProcessor extends AbstractProcessor {

    private int round = 1;

    @Override
    public synchronized void init(final ProcessingEnvironment env) {
        super.init(env);
    }

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment env) {
        System.out.println("Round : " + (this.round++));
        annotations.forEach(System.out::println);
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        final Set<String> supportedAnnotationTypes = new HashSet<>();
        supportedAnnotationTypes.add("*");

        return supportedAnnotationTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }
}
