import java.util.Scanner;

public class Login {
    
    private static Scanner scanner = new Scanner(System.in);
    private static User user= new User();

    public static void login(){
        Boolean islogin = false;


        while (true) {
            boolean isUsername = false;
            //nhập tài khoản
            while (true) {// kiểm tra tài khoản đã có hay chưa??
                if(isUsername == false){
                    System.out.print("nhap username: ");
                    String username = scanner.nextLine();
                    for(User us : Main.users){
                        if(Main.checkUsernameInUsers(username)){
                            isUsername = true;
                            user = us;
                        }
                    }

                } else {// nhập lại tài khoản
                    System.out.println("kiem tra lai username");
                    
                }

                if(isUsername==true){//chuyển sang nhập mật khẩu
                    break;
                }
            }

            //nhập mật khẩu
            
            System.out.print("nhap password: ");
            String password = scanner.nextLine();
                
            if(user.checkpassword(password)){
                islogin = true;
            } else{
                System.out.println("nhap sai passwork ");
                System.out.println(" dang nhap lai ");
                System.out.println("quen passwork ");
                System.out.println("hay nhap vao day ");
                int key = Integer.parseInt(scanner.nextLine());
                if (key==1) {
                }else if(key == 2){// hiển thị mật khẩu.
                    forgetPassword();
                }
            }
            
            if (islogin == true) {
                System.out.println("dang nhap thanh cong!!!");
                break;
            }
        }

    }
    public static void updateInfo(){
            while (true) {
                
                menu();
                System.out.print("chon chương trình: ");
                int key = Integer.parseInt(scanner.nextLine());
                switch (key) {
                    case 1:// thay đổi tài khoản
                        changeUsername();
                        break;
                    case 2://thay đổi email
                        changeEmail();
                        break;
                    case 3:// thay đổi mật khẩu
                        changePassword();
                        break;
                    case 4:// đăng suất
                    Main.loginAndRegister();
                        break;
                    case 0:
                    Main.isQuit = true;
                        break;
                
                    default:
                        break;
                }
                if (Main.isQuit==true) {
                    break;
                }
            }


        
    }

    private static void changePassword() {
        boolean isChange = false;

        while (true) {
            System.out.print("nhap passwork muon thay doi: ");
            String password = scanner.nextLine();

            if(Main.Password(password)){//kiểm tra email
                for(User us: Main.users){
                    if (us.getUsername().equals(user.getUsername())) {
                        us.setPasswork(password);
                        isChange = true;
                    }
                }
            }else {
                System.out.println("sai cau chuc moi nhap lai ");
            }


            if(isChange == true){
                System.out.println("thay doi thanh cong");
                break;
            }

        }
    }

    private static void changeEmail() {
        boolean isChange = false;
        while (true) {
            System.out.print("nhap email muon thay doi: ");
            String email = scanner.nextLine();

            if(Main.Email(email)){//kiểm tra email
                if (Main.checkEmailInUsers(email)) {//kiểm tra email có tồn tại chưa??
                    System.out.println("email da ton tai");
                }else {
                    for(User us: Main.users){
                        if (us.getUsername().equals(user.getUsername())) {
                            us.setEmail(email);
                            isChange = true;
                        }
                    }
                }
            }else {
                System.out.println("sai cau truc email");
            }
            if(isChange == true){
                System.out.println("thay doi thanh cong");
                break;
            }

        }
    }

    private static void changeUsername() {
        boolean isChange = false;

        while (true) {
            System.out.print("nhap username muon thay doi: ");
            String username = scanner.nextLine();
            if(Main.checkUsernameInUsers(username)){//kiểm tra tài khoản có tồn tại hay chưa?
                System.out.println("username da ton tai");
            } else{
                for(User us: Main.users){
                    if (us.getUsername().equals(user.getUsername())) {
                        us.setUsername(username);
                        isChange = true;
                    }
                }
            }

            if(isChange == true){
                System.out.println("thay doi thanh cong");
                break;
            }
        }

        
    }

    private static void menu() {
        System.out.println("1 - thay doi username");
        System.out.println("2 - thay doi email");
        System.out.println("3 - thay doi passwork");
        System.out.println("4 - dang xuat ");
        System.out.println("0 - thoat ");
    }

    private boolean findUserinUsers(User user){
        boolean isUser = false;
        for(User us: Main.users){
            if(us.getUsername().equals(user.getUsername())){
                isUser = true;
            }
        }
        return isUser;
    }
    private static void forgetPassword(){
        boolean isForget = true;
        while (true) {
            System.out.print("hay nhap email da dang ky: ");
            String email = Main.scanner.nextLine();
            for(User us : Main.users){
                if(us.checkemail(email)){
                    System.out.println("nhap mat khau moi: ");
                    String password = Main.scanner.nextLine();
                    if (Main.Password(password)) {
                        us.setPasswork(password);
                        isForget = false;
                    }
                }
            }
            if (isForget== false) {
                System.out.println("thay doi thanh cong");
                break;
            }

        }

    }

}
