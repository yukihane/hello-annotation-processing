package jp.himeji_cs.hello_ap.processor;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.ws.rs.Path;

public class MyProcessor extends AbstractProcessor {

    @Override
    public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment env) {
        for (final Element element : env.getElementsAnnotatedWith(Path.class)) {
            System.out.println(element);
            System.out.println("getAnnotationMirrors: " + element.getAnnotationMirrors());
            System.out.println("getEnclosedElements: " + element.getEnclosedElements());
            System.out.println();
        }

        System.out.println("-----");

        for (final TypeElement anno : annotations) {
            System.out.println(anno);
            System.out.println("getEnclosedElements: " + anno.getEnclosedElements());
            System.out.println("getNestingKind: " + anno.getNestingKind());
            System.out.println("getQualifiedName: " + anno.getQualifiedName());
            System.out.println("getSimpleName: " + anno.getSimpleName());
            System.out.println("getSuperclass: " + anno.getSuperclass());
            System.out.println("getInterfaces: " + anno.getInterfaces());
            System.out.println("getTypeParameters: " + anno.getTypeParameters());
            System.out.println("getEnclosingElement: " + anno.getEnclosingElement());

            for (final Element elem : env.getElementsAnnotatedWith(anno)) {
                System.out.println("getSimpleName: " + elem.getSimpleName());
                System.out.println("asType: " + elem.asType());
                System.out.println("getKind: " + elem.getKind());
                System.out.println("getModifiers: " + elem.getModifiers());
                System.out.println("getEnclosingElement: " + elem.getEnclosingElement());
                System.out.println("getEnclosedElements: " + elem.getEnclosedElements());
                System.out.println("getAnnotationMirrors: " + elem.getAnnotationMirrors());

            }

            System.out.println();
        }

        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        final Set<String> supportedAnnotationTypes = new HashSet<>();
        supportedAnnotationTypes.add("javax.ws.rs.*");

        return supportedAnnotationTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }
}
