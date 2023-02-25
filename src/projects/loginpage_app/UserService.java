package projects.loginpage_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//5.adim user objesiyle ilgili islemleri gerceklestirecegim
public class UserService {
   // 6.adim kullanici bilgilerini kaydetme
List<User> userList=new ArrayList<>();

//tum metotlarda kullanicidan bilgi almak icin scanner obj olusturduk
Scanner inp=new Scanner(System.in);


// 7- kullanicinin username veya email bilgisini kullanarak kayitli user i getirmek icin metot olusturacagiz.
    private User getUser(String userNameOrEmail){
        for (User user:userList){
            if (user.getUsername().equals(userNameOrEmail)){
                return user;
            }else if(user.getEmail().equals(userNameOrEmail)){
                return user;
            }

        }
return null; // kayitli kullanici bulamazsam
    }

// 8 - email validation
    private static boolean validateEmail(String email){
boolean isValid;
boolean isExistsSpace=email.contains(" ");
boolean isContainsAt=email.contains("@");
if (isExistsSpace){
    System.out.println("Email bosluk iceremez!");
    isValid=false;
} else if (!isContainsAt) {
    System.out.println("Email @ sembolu icermelidir.");
    isValid=false;
}else { // asd@gmail.com --> iki array yapar [asd, gmail.com]
    String firstPart=email.split("@") [0]; // [asd]
    String secondPart=email.split("@") [1]; // [gmail.com]

   boolean valid= firstPart.replaceAll("[a-zA-Z0-9_.-]", "").isEmpty(); //As-2* olsa idi * haric hepsini siler
    boolean checkStart=valid && firstPart.length()>0; //@gmail.com gibi ilk parcaya veri girmeme durumunu kontrol ettim
    boolean checkEnd=secondPart.equals("gmail.com")||
    secondPart.equals("hotmail.com")||
    secondPart.equals("yahoo.com");

    if (!checkStart){
        System.out.println("Mailin kullanici adi bolumu en az bir karakter icermelidir." +
                "Sadece kucuk buyuk harf, rakam veya -._ icerebilir.");
    }
    if (!checkEnd) {
        System.out.println("Mail gmail.com, hotmail.com, yahoo.com ile bitmelidir.");
    }
    isValid=checkStart && checkEnd;
}

if (!isValid){
    System.out.println("Tekrar deneyiniz.");
}
        return isValid;
    }


    //9 password validation

    private static boolean validatePassword(String password){
        boolean isValid;
      boolean isExistsSpace=password.contains(" ");
      boolean isLengthGThanSix=password.length()>5;
        boolean isExistsUpperLetter=password.replaceAll("[^A-Z]", "").length()>0;
       boolean isExistsLowerLetter=password.replaceAll("[^a-z]", "").length()>0;
       boolean isExistsDigit=password.replaceAll("[\\D]", "").length()>0; //rakam disindakileri sil
        boolean isExistsSymbol=password.replaceAll("[\\P{Punct}]", "").length()>0;
if (isExistsSpace){
    System.out.println("password bosluk iceremez.");
} else if (isLengthGThanSix) {
    System.out.println("password en az 6 karakter icermelidir");
}else if (isExistsUpperLetter) {
    System.out.println("password en az bir buyuk harf icermelidir");
}else if (isExistsLowerLetter) {
    System.out.println("password en az bir kucuk harf icermelidir");
}else if (isExistsDigit) {
    System.out.println("password en az bir rakam icermelidir");
}else if (isExistsSymbol) {
    System.out.println("password en az bir -._ icermelidir");
}

isValid=!isExistsSpace && isLengthGThanSix && isExistsUpperLetter && isExistsLowerLetter && isExistsDigit && isExistsSymbol;

if (!isValid){
    System.out.println("Gecersiz sifre, tekrar deneyin.");
}
        return isValid;
    }

public void register(){
    System.out.println("Ad soyad: ");
    String name=inp.nextLine();

    //10 username unique olmali
    String userName=getUserName();

    //11- email bilgis alma. email uniq olmali, verdigimiz kurallara gore gecerli olmali
String email=getEmail();

// 12 password: gecerli password
    String password=getPassword();
// 13   user objesini olusturacagim
    User user=new User(name, userName,email, password);

    //14 user i listeye kaydedecegim
    this.userList.add(user);
    System.out.println("Tebrikler. Isleminiz basariyla gerceklestirildi.");
    System.out.println("Kullanici adi  veya email ve sifrenizle sisteme giris yapabilirsiniz.");
}


//10-a kullanicidan username alma
    private String getUserName(){
        String userName;
        boolean existsUserName;
        do {
            System.out.println("Kullanici adini giriniz");
            userName=inp.next();
            existsUserName=getUser(userName)!=null; //yukarida username getUser metodu ile
            // alindi mi diye kontrol edecek. null ise devam edecek. username alinip kullanilabilecek.
if (existsUserName){
    System.out.println("Bu kullanici adi kullanilmistir. Farki bir kullanici adi deneyiniz");
}

        }while (existsUserName);




        return userName;
    }

 //   11--a  kullanicinin email olusturmasi
    private String getEmail(){
        String email;
        boolean isValid;
        boolean existsEmail;
        do {
            System.out.println("Lutfen email giriniz");
            email=inp.next(); //email gecerli kontrol edecegiz bundan sonra
            isValid=validateEmail(email); // gecerli ise unique mi diye bundan sonra kontrol etmeliyim
            existsEmail=getUser(email)!=null;
            if (existsEmail){
                System.out.println("Bu email zaten kayitli. Farkli bir email deneyiniz.");
                isValid=false;
            }

        }while (!isValid);

        return email;
    }

    //12-a  password olusturma
    private String getPassword(){
        String password;
        boolean isValidPassword;
        do {
            System.out.println("Sifrenizi giriniz");
            password=inp.next();
            isValidPassword=validatePassword(password);


        }while (!isValidPassword);


        return password;
    }

    //15 email veya username ile giris yapma
    public void login(){
        System.out.println("Kullanici adi veya emailinizi giriniz lutfen.");
        String userOrEmail=inp.next();

        //16 girilen deger ile user i bulacagim
        if (getUser(userOrEmail)!=null){
            User user=getUser(userOrEmail);

    //   17 user bulunduysa sifre kontrol edecegim
        boolean isWrong=true;
        while (isWrong){
            System.out.println("Sifrenizi giriniz");
            String password=inp.next();
        //sifre kayitli sifre ile ayni mi kontrol edecegim
        if (user.getPassword().equals(password)){
            System.out.println("Sisteme giris yaptiniz");
            isWrong=false;
        }else {
            System.out.println("Sifreniz yanlis, tekrar deneyiniz");
        }

        }
    }else {
            System.out.println("Sistemde kayitli kullanici adi veya email bulunamadi.");
            System.out.println("Uyeyseniz bilgilerinizi kontrol ederek tekrar deneyiniz, uye degilseniz lutfen uye olunuz.");
        }
    }
}
