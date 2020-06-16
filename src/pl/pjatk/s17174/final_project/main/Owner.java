/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

/**
 * Class which stores data about owner
 * links with Plane with cardinality 0..1 - 1..*
 *
 * @author Lukasz
 * @see Plane
 */
public class Owner extends ObjectPlusPlus {

    private String name;

    public Owner(String name) {
        super();
        this.name = name;
    }

    public void buyPlane() {
        //todo
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                '}';
    }
}
