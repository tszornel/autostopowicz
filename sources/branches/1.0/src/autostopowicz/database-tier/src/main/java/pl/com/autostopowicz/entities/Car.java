// default package
// Generated 2008-04-13 11:32:14 by Hibernate Tools 3.2.0.b11
package pl.com.autostopowicz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Car generated by hbm2java
 */
@Entity
public class Car implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4230867100172061700L;
	private Integer idCar;
	private String make;
	private String model;
	private String color;
	private String numberPlate;

	public Car() {
	}

	public Car(String make, String model, String color, String numberPlate) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.numberPlate = numberPlate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = "    ";

		String retValue = "";

		retValue = "Car ( " + super.toString() + TAB + "idCar = " + this.idCar
				+ TAB + "make = " + this.make + TAB + "model = " + this.model
				+ TAB + "color = " + this.color + TAB + "numberPlate = "
				+ this.numberPlate + TAB + " )";

		return retValue;
	}

}
