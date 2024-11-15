// default package
// Generated 2008-04-13 11:16:03 by Hibernate Tools 3.2.0.b11


import java.util.HashSet;
import java.util.Set;

/**
 * Car generated by hbm2java
 */
public class Car  implements java.io.Serializable {


     private Integer idCar;
     private String make;
     private String model;
     private String color;
     private String numberPlate;
     private Set usercars = new HashSet(0);
     private Set drives = new HashSet(0);

    public Car() {
    }

	
    public Car(String make, String model, String color, String numberPlate) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.numberPlate = numberPlate;
    }
    public Car(String make, String model, String color, String numberPlate, Set usercars, Set drives) {
       this.make = make;
       this.model = model;
       this.color = color;
       this.numberPlate = numberPlate;
       this.usercars = usercars;
       this.drives = drives;
    }
   
    public Integer getIdCar() {
        return this.idCar;
    }
    
    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }
    public String getMake() {
        return this.make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getNumberPlate() {
        return this.numberPlate;
    }
    
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
    public Set getUsercars() {
        return this.usercars;
    }
    
    public void setUsercars(Set usercars) {
        this.usercars = usercars;
    }
    public Set getDrives() {
        return this.drives;
    }
    
    public void setDrives(Set drives) {
        this.drives = drives;
    }




}


