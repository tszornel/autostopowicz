package pl.com.autostopowicz.database.entities;
// Generated 2008-04-13 11:32:14 by Hibernate Tools 3.2.0.b11



/**
 * UsergroupId generated by hbm2java
 */
public class UsergroupId  implements java.io.Serializable {


     private int idUser;
     private int idGroup;

    public UsergroupId() {
    }

    public UsergroupId(int idUser, int idGroup) {
       this.idUser = idUser;
       this.idGroup = idGroup;
    }
   
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public int getIdGroup() {
        return this.idGroup;
    }
    
    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsergroupId) ) return false;
		 UsergroupId castOther = ( UsergroupId ) other; 
         
		 return (this.getIdUser()==castOther.getIdUser())
 && (this.getIdGroup()==castOther.getIdGroup());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdUser();
         result = 37 * result + this.getIdGroup();
         return result;
   }   


}


