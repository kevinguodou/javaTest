package com.example.demo.jdk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * @author dou.guo
 * @version PropertyChange, v 0.1 2022-09-01 12:32 下午 dou.guo Exp $
 */
public class PropertyChange implements Serializable {

    private static final long serialVersionUID = 1L;

    private int serverPort = 8012;

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);


    public void addPropertyChangeListener(final String propertyName, final PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        //将属性的改变通知给监听，让监听器可以得知此改变
        changeSupport.firePropertyChange("serverPort", this.serverPort, serverPort);
        this.serverPort = serverPort;
    }

    public static void main(String[] args) {
        final PropertyChange config = new PropertyChange();
        config.addPropertyChangeListener("serverPort", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("ok");
            }
        });

        System.out.println("8888");
        config.setServerPort(8888);
        config.setServerPort(8889);
        config.setServerPort(8890);
    }

}
