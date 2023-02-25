package projects.loginpage_app;

import java.util.Scanner;

/*
    Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

            menü: kullanıcıya işlem seçimi için menü gösterilir.

    üye olma(register): kullanıcıdan ad-soyad, kullanıcı adı, email ve şifre bilgileri alınız.
    kullanıcı adı, email ve şifre birer listede tutulur.
    aynı kullanıcı adı veya email kabul edilmez.

            giriş(login): kullanıcı adı/email ve şifre girilir.
    kullanıcı adı veya email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
    kullanıcı adı/email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

    email validation: boşluk içermemeli
                         : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                         : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

    password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli
 */
public class LoginpageApp {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        //  1.adım kullaniciya islem menusu gosterecegiz

        Scanner inp=new Scanner(System.in);
        UserService service= new UserService();
        int select;
        do {
            System.out.println("====== TECHPROECUCATION =========");
            System.out.println("1- Uye ol");
            System.out.println("2- Giris yap");
            System.out.println("3- Cikis");
            select= inp.nextInt();

            switch (select){
                case 1:
                    //register
                    service.register();
                    System.out.println(service.userList);
                    break;
                case 2:
                service.login();
                    break;
                case 3:
                    System.out.println("Iyi gunler dileriz.");
                    break;
                default:
                    System.out.println("Hatali giris yaptiniz. Tekrar deneyiniz.");
                    break;
            }

        }while (select!=0);

 // 2. adim userlarin ortak ozellikleri olacak. user class olusturacagiz.



    }

}
