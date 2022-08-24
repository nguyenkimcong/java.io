import javax.sound.midi.Soundbank;

public class User {
   private String username;
   private String passwork;
  private String email;

  public User (){

  }


  public User(String username, String passwork, String email) {
    this.username = username;
    this.passwork = passwork;
    this.email = email;
  }


  public String getUsername() {
    return username;
  }


  public String getPasswork() {
    return passwork;
  }


  public String getEmail() {
    return email;
  }


public void setUsername(String username) {
    this.username = username;
}


public void setPasswork(String passwork) {
    this.passwork = passwork;
}


public void setEmail(String email) {
    this.email = email;
}



public void printInfo(){
  System.out.printf("%15s %15s %15s",this.username,this.passwork,this.email);
}

public boolean checkUserName (String username){
  boolean result = this.username.equals(username);
  return result;
}
  public boolean checkpassword( String password){
    boolean result = this.passwork.equals(password);
    return result;
  }

  public boolean checkemail( String email){
    boolean result = this.email.equals(email);
    return result;
  }
     
}

  
   
   