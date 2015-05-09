/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;


public class AccountDTO {

    private int  UID;
    private String Username;
    private String Password;
    private String Role;
    private String Fullname;
    private String Email;
    private String Address;
    private String Phone;

    public AccountDTO(){
        }

    public AccountDTO(int UID, String Username, String Password, String Role, String Fullname, String Email, String Address, String Phone) {
        this.UID = UID;
        this.Username = Username;
        this.Password = Password;
        this.Role = Role;
        this.Fullname = Fullname;
        this.Email = Email;
        this.Address = Address;
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    
}
