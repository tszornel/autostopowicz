// default package
// Generated 2008-04-13 11:16:03 by Hibernate Tools 3.2.0.b11



/**
 * Usergroup generated by hbm2java
 */
public class Usergroup  implements java.io.Serializable {


     private UsergroupId id;
     private User user;
     private Group group;
     private boolean owner;

    public Usergroup() {
    }

    public Usergroup(UsergroupId id, User user, Group group, boolean owner) {
       this.id = id;
       this.user = user;
       this.group = group;
       this.owner = owner;
    }
   
    public UsergroupId getId() {
        return this.id;
    }
    
    public void setId(UsergroupId id) {
        this.id = id;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Group getGroup() {
        return this.group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }
    public boolean isOwner() {
        return this.owner;
    }
    
    public void setOwner(boolean owner) {
        this.owner = owner;
    }




}


