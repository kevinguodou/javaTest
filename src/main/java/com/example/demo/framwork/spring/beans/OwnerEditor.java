package com.example.demo.framwork.spring.beans;



import com.example.demo.framwork.spring.*;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;

import java.beans.PropertyEditorManager;
import java.beans.PropertyEditorSupport;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * @author dou.guo
 * @version PropertyeeditorsTest, v 0.1 2022-09-01 1:57 下午 dou.guo Exp $
 */
public class OwnerEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // text contains a sequence of petname/age/species, separated by comma’s
        ArrayList pets = new ArrayList();
        StringTokenizer t = new StringTokenizer(text, ",");
        while (t.hasMoreTokens()) {
            String name_owner_species = t.nextToken();
            StringTokenizer nos = new StringTokenizer(name_owner_species, "/");
            Pet pet = new Pet();
            pet.setName(nos.nextToken());
            try {
                pet.setAge(Integer.parseInt(nos.nextToken()));
            } catch(NumberFormatException e) {
                pet.setAge(0);
            }
            pet.setSpecies(new Species(nos.nextToken()));
            pets.add(pet);
        }
        setValue(pets);
    }

    public void editorTest() {
        PropertyEditorManager.registerEditor(List.class, OwnerEditor.class);
        Owner isabelle = new Owner();
        BeanWrapper bw = new BeanWrapperImpl(isabelle);
        try {
            bw.setPropertyValue("name", "Isabelle");
            bw.setPropertyValue("pets", "Bodo/4/Cat,Pixel/11/Dog,Raphael/6/Cat");
        } catch (BeansException e) {
            e.printStackTrace();
        }
        System.out.println("Property editor : " + isabelle.getName() + "’s pets are: ");
        ListIterator iter = isabelle.getPets().listIterator();
        while (iter.hasNext()) {
            IPet pet = (IPet)iter.next();
            ISpecies sp = pet.getSpecies();
            System.out.println(pet.getName() + " of species " + sp.getName());
        }
    }

    public static void main(String[] args) {

    }

}
