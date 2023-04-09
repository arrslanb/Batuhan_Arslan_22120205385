
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramTest {
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        String islemler="\n************** PROGRAMA HOŞGELDİNİZ **************\n" +
                "1)ELİT ÜYE EKLEME\n" +
                "2)GENEL ÜYE EKLEME\n" +
                "3)MAİL GÖNDERME\n" +
                "4)Çıkış";
        boolean bayrak=true;//Döngü değişkenimiz
        while (bayrak){
            System.out.println(islemler);
            System.out.print("İşlem Seçiniz:");
            int islem=scan.nextInt();
            switch (islem){
                case 1:
                    System.out.print("Ad:");
                    scan.nextLine();
                    String elitAd=scan.nextLine();
                    System.out.print("Soyad:");
                    String elitSoyad=scan.nextLine();
                    System.out.print("Email:");
                    String elitMail=scan.nextLine();
                    EliteUye eUye=new EliteUye(elitAd,elitSoyad,elitMail);
                    eUye.uyeEkle(eUye);
                    System.out.println("Elit Üye Başarı İle Eklendi");
                    break;
                case 2:
                    System.out.print("Ad:");
                    scan.nextLine();
                    String normalAd=scan.nextLine();
                    System.out.print("Soyad:");
                    String normalSoyad=scan.nextLine();
                    System.out.print("Email:");
                    String normalMail=scan.nextLine();
                    NormalUye nUye=new NormalUye(normalAd,normalSoyad,normalMail);
                    nUye.uyeEkle(nUye);
                    System.out.print("Normal Üye Başarı İle Eklendi");
                    break;
                case 3:
                    String mailIslem="1)Elit üyelere mail \n" +
                            "2)Genel üyelere mail\n" +
                            "3)Tüm üyelere mail\n" +
                            "4)Ana Menü\n";
                    System.out.print(mailIslem);
                    System.out.print("İşlem Seçiniz:");
                    int mailSecim=scan.nextInt();
                    switch (mailSecim){
                        case 1:
                            System.out.print("Mail Konusu:");
                            scan.nextLine();
                            String konu1=scan.nextLine();
                            System.out.print("Atılacak Mail Metni:");
                            String mail1=scan.nextLine();
                            Mail.mailGonder(EliteUye.eliteUyemail,konu1,mail1);
                            break;
                        case 2:
                            System.out.print("Mail Konusu:");
                            scan.nextLine();
                            String konu2=scan.nextLine();
                            System.out.print("Atılacak Mail Metni:");
                            String mail2=scan.nextLine();
                            Mail.mailGonder(NormalUye.normalUyemail,konu2,mail2);
                            break;
                        case 3:
                            ArrayList<String> tumAlicilar=new ArrayList<String>();//Tüm alıcıların Bulunduğu ArrayList
                            tumAlicilar.addAll(EliteUye.eliteUyemail);//Elit ve Normal Alıcıları Tüm Alıcılar ArrayListine Ekleme
                            tumAlicilar.addAll(NormalUye.normalUyemail);
                            System.out.print("Mail Konusu:");
                            scan.nextLine();
                            String konu3=scan.nextLine();
                            System.out.print("Atılacak Mail Metni:");
                            String mail3=scan.nextLine();
                            Mail.mailGonder(tumAlicilar,konu3,mail3);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.print("Geçersiz İşlem!!!!");
                    }
                    break;
                case 4:
                    System.out.println("Çıkış Yapılıyor!!!!.");
                    bayrak=false;
                    break;
                default:
                    System.out.print("Geçersiz İşlem!!!!!");
            }
        }
    }
}