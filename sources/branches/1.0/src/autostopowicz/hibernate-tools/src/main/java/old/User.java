// default package
// Generated 2008-04-13 11:16:03 by Hibernate Tools 3.2.0.b11


import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private Integer idUser;
     private Country country;
     private City city;
     private String login;
     private String password;
     private String email;
     private int role;
     private int rank;
     private String name;
     private String surname;
     private String address;
     private String phone;
     private String description;
     private Set usercars = new HashSet(0);
     private Set usergroups = new HashSet(0);
     private Set drives = new HashSet(0);

    public User() {
    }

	
    public User(String login, String password, String email, int role, int rank) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.rank = rank;
    }
    public User(Country country, City city, String login, String password, String email, int role, int rank, String name, String surname, String address, String phone, String description, Set usercars, Set usergroups, Set drives) {
       this.country = country;
       this.city = city;
       this.login = login;
       this.password = password;
       this.email = email;
       this.role = role;
       this.rank = rank;
       this.name = name;
       this.surname = surname;
       this.address = address;
       this.phone = phone;
       this.description = description;
       this.usercars = usercars;
       this.usergroups = usergroups;
       this.drives = drives;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public Country getCountry() {
        return this.country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public int getRole() {
        return this.role;
    }
    
    public void setRole(int role) {
        this.role = role;
    }
    public int getRank() {
        return this.rank;
    }
    
    public void setRank(int rank) {
        this.rank = rank;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getUsercars() {
        return this.usercars;
    }
    
    public void setUsercars(Set usercars) {
        this.usercars = usercars;
    }
    public Set getUsergroups() {
        return this.usergroups;
    }
    
    public void setUsergroups(Set usergroups) {
        this.usergroups = usergroups;
    }
    public Set getDrives() {
        return this.drives;
    }
    
    public void setDrives(Set drives) {
        this.drives = drives;
    }




}


