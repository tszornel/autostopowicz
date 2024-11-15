package pl.com.autostopowicz.entities;
// Generated 2008-04-13 11:32:14 by Hibernate Tools 3.2.0.b11


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Group generated by hbm2java
 */
@Entity
public class Group  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 5573812846803496626L;
	private Integer idGroup;
     private String name;
     private byte[] logo;
     private String description;
    
    public Group() {
    }

	
    public Group(String name) {
        this.name = name;
    }
    public Group(String name, byte[] logo, String description) {
       this.name = name;
       this.logo = logo;
       this.description = description;
      
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getIdGroup() {
        return this.idGroup;
    }
    
    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    
  




}


