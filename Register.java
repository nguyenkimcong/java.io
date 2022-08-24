public class Register {
    static User user = new User();
    
    /**
     * 
     */
    public static void register(){
        while (true) {
            String username = addUsername();
            String email = addEmail();
            String password = addPassword();
            if (username.length() + email.length() + password.length() > 3) {
                Main.users.add(new User(username, password, email));
                System.out.println("them tai khoan thanh cong");
                break;
            }
        }


    }
    private static String addUsername(){
        boolean isUsername = false;
        String result = "";
        while (true) {
            System.out.print("nhap username: ");
            String username = Main.scanner.nextLine();
            if (Main.checkUsernameInUsers(username)) {
                System.out.println("usernam da ton tai");
            }else{ 
                result = username;
                isUsername = true;
            }

            if (isUsername == true) {
                System.out.println("username hop le");
                break;
            }
        }
        return result;
    }
    private static String addEmail(){

        Boolean isEmail = false;
        String result = "";

        while (true) {
            System.out.print("nhap email: ");
            String email = Main.scanner.nextLine();
            if (Main.Email(email)) {
                if (Main.checkEmailInUsers(email)) {
                    System.out.println("email da ton tai");
                }else{
                    result = email;
                    isEmail = true;
                }

            }else{ 
                System.out.println("email khong hop le");
            }

            if (isEmail == true) {
                System.out.println("email hop le");
                break;
            }
        }
        return result;
    }
    private static String addPassword(){
        boolean isPassword = false;
        String result = "";
        while (true) {
            System.out.print("nhap pass: ");
            String password = Main.scanner.nextLine();
            if (Main.Password(password)) {
                result = password;
                isPassword = true;
            }else{
                System.out.println("pass khong hop len");
            }

            if (isPassword == true) {
                System.out.println("pass hop le");
                break;
            }
        }
        return result;
    }
}

