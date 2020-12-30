package TechSupport;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.UnavailableException;

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
    
    private String prenom;
    
    private String nom;
    
    private String telephone;
    
    private PropertyChangeSupport propertySupport;
    
    private String BDD_URL;
    
    
    public TechSupportBean() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public void createTable(String query){
        try {
            java.sql.Statement statement = this.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
        } catch (Exception ex) {
            Logger.getLogger(TechSupportBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        String create_table = "CREATE TABLE user (id INT  PRIMARY KEY NOT NULL, PRENOM VARCHAR(10), "
                    + "NOM VARCHAR(10), EMAIL VARCHAR(50), TELEPHONE CHAR(10), LOGICIEL VARCHAR(20), OS VARCHAR(20), PROBLEME VARCHAR(10) )";
        String insert_supp_requests = "INSERT INTO user id, PRENOM, NOM, EMAIL, TELEPHONE, LOGICIEL, OS, PROBLEME "
                    + "VALUES ('1', 'xianli', 'Li', 'lixianlilxl@gmail.com', '0611111111', 'google', 'windows', 'blabla')";*/
    }

    public boolean isUserExists(String query){
        try {
            java.sql.Statement statement = this.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            return result.next();
        } catch (Exception ex) {
            Logger.getLogger(TechSupportBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        /*
        String create_table = "CREATE TABLE user (id INT  PRIMARY KEY NOT NULL, PRENOM VARCHAR(10), "
                    + "NOM VARCHAR(10), EMAIL VARCHAR(50), TELEPHONE CHAR(10), LOGICIEL VARCHAR(20), OS VARCHAR(20), PROBLEME VARCHAR(10) )";
        String insert_supp_requests = "INSERT INTO user id, PRENOM, NOM, EMAIL, TELEPHONE, LOGICIEL, OS, PROBLEME "
                    + "VALUES ('1', 'xianli', 'Li', 'lixianlilxl@gmail.com', '0611111111', 'google', 'windows', 'blabla')";*/
    }
    
    public String selectQuery(String query){
        try {
            PreparedStatement selectStatement = this.getConnection().prepareStatement(query);
            selectStatement.setString(1, email);
            ResultSet rs = selectStatement.executeQuery();
            if (rs.next()) {
                return rs.getString(0);
            }
            return "ca marche pas snif";
        } catch (Exception ex) {
            //Logger.getLogger(TechSupportBean.class.getName()).log(Level.SEVERE, null, ex);
            return ex.toString();
        }
        //return "ca marche pas merde";
    }
    
    public void insertQuery(String query){
        try {
            java.sql.Statement statement = this.getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
            Logger.getLogger(TechSupportBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected Connection getConnection() throws UnavailableException {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String url = "jdbc:derby://localhost:1527/hotline;create=true";
        try {
            Class.forName(driver).newInstance();
            Properties userInfo = new Properties();
            userInfo.put("user", "Xianli");
            userInfo.put("password", "lxl19971211");
            Connection connection =  DriverManager.getConnection(url, userInfo);
            return(connection);
        } catch (ClassNotFoundException ex) {
            throw new UnavailableException("Le driver n'est pas trouvé dans le classpath.");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TechSupportBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TechSupportBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TechSupportBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Establish network connection to database.
        
        return null;
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
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        String oldValue = this.prenom;
        this.prenom = prenom;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, this.prenom);
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        String oldValue = this.nom;
        this.nom = nom;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, this.nom);
    }
    
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        String oldValue = this.telephone;
        this.telephone = telephone;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, this.telephone);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
