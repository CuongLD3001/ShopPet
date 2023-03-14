/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Account {
    private int id;
    private String user;
    private String pass;
    private String email;
    private String phone;
    private Boolean gender;
    private String dateOfBirth;
    private String securityQuestion;
    private String answer;
    private int isSell;
    private int isAdmin;
    private int active;

    public Account() {
    }

    public Account(int id, String user, String pass, String email, String phone, Boolean gender, String dateOfBirth, String securityQuestion, String answer, int isSell, int isAdmin, int active) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.securityQuestion = securityQuestion;
        this.answer = answer;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", user=" + user + ", pass=" + pass + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", securityQuestion=" + securityQuestion + ", answer=" + answer + ", isSell=" + isSell + ", isAdmin=" + isAdmin + ", active=" + active + '}';
    }

    
   
    
    
    
}
