package javaapps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuadraticEquationSolver {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        QuadraticEquation quadraticEquation = (QuadraticEquation) context.getBean("quadraticequation");
//        System.out.println((quadraticEquation.findDiscriminant()).toString());
        System.out.println((quadraticEquation.findRoots().toString()));
    }
}
