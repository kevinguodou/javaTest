package com.example.demo.framwork.spring.context;


import com.example.demo.framwork.spring.IOwner;
import com.example.demo.framwork.spring.IPet;
import com.example.demo.framwork.spring.Owner;
import com.example.demo.framwork.spring.beans.OwnerEditor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.beans.PropertyEditorManager;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author dou.guo
 * @version Context, v 0.1 2022-09-01 4:37 下午 dou.guo Exp $
 */
public class AppContext  {

    FileSystemXmlApplicationContext ctx;

    public AppContext() {
        PropertyEditorManager.registerEditor(List.class, OwnerEditor.class);
        String sep = System.getProperty("file.separator");
        // The parent context
        StringBuffer buff1 = new StringBuffer();
        buff1.append("src").append(sep).append("main").append(sep).
                append("resources").append(sep).append("appContext.xml");
        // The child context
        StringBuffer buff2 = new StringBuffer();
        buff2.append("src").append(sep).append("main").append(sep).
                append("resources").append(sep).append("babyContext.xml");
        try {
            ctx = new FileSystemXmlApplicationContext(new String[]
                    {buff1.toString(), buff2.toString()});
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AppContext appContext = new AppContext();
        appContext.testEvents();
        appContext.listBeans();
    }

    public void testEvents() {
        try {
            Owner isabelle = (Owner)ctx.getBean("isabelle");
            if (null != isabelle) {
                isabelle.feedPets();
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    public void listBeans() {
        try {
            IPet pet = (IPet)ctx.getBean("bodo");
            if (null != pet){
                System.out.println("Found " + pet.getName() + " of species " +
                        pet.getSpecies().getName());
            }

            pet = (IPet)ctx.getBean("raphael");
            if (null != pet){
                System.out.println("Found " + pet.getName() + " of species " +
                        pet.getSpecies().getName());
            }

            pet = (IPet)ctx.getBean("pixel");
            if (null != pet){
                System.out.println("Found " + pet.getName() + " of species " +
                        pet.getSpecies().getName());
            }

            ApplicationContext parent = ctx.getParent();
            if (null != parent) {
                IOwner o = (IOwner)parent.getBean("isabelle");
                if (null != o){
                    System.out.println("Found " + o.getName());
                }
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    /*public void testSharedObject() {
        class Foo {
            void foo() {
                System.out.println("I am a Foo shared object");
            }
        }
        ctx.shareObject("foo", new Foo());
        Foo foo = (Foo)ctx.sharedObject("foo");
        if (null != foo){
            foo.foo();
        }
    }*/

}
