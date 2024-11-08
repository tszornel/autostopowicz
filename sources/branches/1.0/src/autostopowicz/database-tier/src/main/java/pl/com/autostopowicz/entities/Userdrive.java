package pl.com.autostopowicz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userdrive implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5134782757968070396L;
	/**
	 * 
	 */

	private Integer idUserDrive;
	private Integer idUser;
	private Integer idDrive;


	public Userdrive(Integer idUserDrive, Integer idUser, Integer idDrive) {
		super();
		this.idUserDrive = idUserDrive;
		this.idUser = idUser;
		this.idDrive = idDrive;
		
	}

	public Userdrive() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdUserDrive() {
		return idUserDrive;
	}

	public void setIdUserDrive(Integer idUserDrive) {
		this.idUserDrive = idUserDrive;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdDrive() {
		return idDrive;
	}

	public void setIdDrive(Integer idDrive) {
		this.idDrive = idDrive;
	}



	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "Userdrive ( "
	        + super.toString() + TAB
	        + "idUserDrive = " + this.idUserDrive + TAB
	        + "idUser = " + this.idUser + TAB
	        + "idDrive = " + this.idDrive + TAB
	        + " )";
	
	    return retValue;
	}

	

}
