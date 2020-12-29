package TechSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Xianli
 */
public class TechSupportBean implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String email;
    
    private String logiciel;
    
    private String systemeExploitation;
    
    private String description;
    
    private PropertyChangeSupport propertySupport;
    
    public TechSupportBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        String oldValue = this.email;
        this.email = email;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, this.email);
    }
    
    public String getLogiciel() {
        return logiciel;
    }
    
    public void setLogiciel(String logiciel) {
        String oldValue = this.logiciel;
        this.logiciel = logiciel;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, this.logiciel);
    }
    
    public String getSystemeExploitation() {
        return this.systemeExploitation;
    }
    
    public void setSystemeExploitation(String systemeExploitation) {
        String oldValue = this.systemeExploitation;
        this.systemeExploitation = systemeExploitation;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, this.systemeExploitation);
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        String oldValue = this.description;
        this.description = description;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, this.description);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
