package com.julien.myblog.bean;


/**
 * @function: User
 * @author: 863978160@qq.com
 * @create: 2021-01-19 18:51
 **/

/**
 *
 */
 public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String chatqq;
    private String cover;
    private String petname;

    public User(){

    }

   public User(Integer id, String username, String password, String email, String chatqq, String cover, String petname) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.email = email;
      this.chatqq = chatqq;
      this.cover = cover;
      this.petname = petname;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", password='" + password + '\'' +
              ", email='" + email + '\'' +
              ", chatqq='" + chatqq + '\'' +
              ", cover='" + cover + '\'' +
              ", petname='" + petname + '\'' +
              '}';
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getChatqq() {
      return chatqq;
   }

   public void setChatqq(String chatqq) {
      this.chatqq = chatqq;
   }

   public String getCover() {
      return cover;
   }

   public void setCover(String cover) {
      this.cover = cover;
   }

   public String getPetname() {
      return petname;
   }

   public void setPetname(String petname) {
      this.petname = petname;
   }
}
