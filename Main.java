package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import member.bean.User;

public class Main {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("1. 一般ユーザーを登録");
            System.out.println("2. 管理者ユーザーを登録");
            System.out.println("3. ユーザー情報を表示");
            System.out.println("4. 終了");
            System.out.print("選択してください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 改行文字を消費

            switch (choice) {
                case 1:
                    registerGeneralUser(scanner);
                    break;
                case 2:
                    registerAdminUser(scanner);
                    break;
                case 3:
                    findUsers();
                    break;
                case 4:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("無効な選択です。");
            }
        }

        scanner.close();
    }

    // 一般ユーザーを登録するメソッド
    public void registerGeneralUser(Scanner scanner) {
        System.out.print("名前を入力してください: ");
        String name = scanner.nextLine();
        System.out.print("メールアドレスを入力してください: ");
        String email = scanner.nextLine();
        
        if (isEmailRegistered(email)) {
            System.out.println("このメールアドレスは既に登録されています。");
            return;
        }
        
        GeneralUser generalUser = new GeneralUser(name, email);
        users.add(generalUser);
        System.out.println("一般ユーザーが登録されました。");
    }
    // 管理者ユーザーを登録するメソッド
    public void registerAdminUser(Scanner scanner) {
        System.out.print("名前を入力してください: ");
        String name = scanner.nextLine();
        System.out.print("メールアドレスを入力してください: ");
        String email = scanner.nextLine();
        
        if (isEmailRegistered(email)) {
            System.out.println("このメールアドレスは既に登録されています。");
            return;
        }

        System.out.print("管理者コードを入力してください: ");
        String adminCode = scanner.nextLine();
        AdminUser adminUser = new AdminUser(name, email, adminCode);
        users.add(adminUser);
        System.out.println("管理者ユーザーが登録されました。");
    }

    // メールアドレスが既に登録されているか確認するメソッド
    public boolean isEmailRegistered(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }
    // 登録されたユーザーを表示するメソッド
    public void findUsers() {
        if (users.isEmpty()) {
            System.out.println("登録されたユーザーはまだいません。");
        } else {
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }
}
