import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NormalUye {
    static ArrayList<String> normalUyead=new ArrayList<String>();//üye adlarının yer alacağı ArrayList
    static ArrayList<String> normalUyesoyad=new ArrayList<String>();//üye soyadlarının yer alacağı ArrayList
    static ArrayList<String> normalUyemail=new ArrayList<String>();//üye mail adreslerinin yer alacağı ArrayList
    private String ad;
    private String soyAd;
    private String eMail;

    public NormalUye(String ad, String soyAd, String eMail) throws IOException {
        this.ad = ad;
        this.soyAd = soyAd;
        this.eMail = eMail;
        normalUyead.add(ad);
        normalUyesoyad.add(soyAd);
        normalUyemail.add(eMail);
    }

     public void uyeEkle(NormalUye uye) throws IOException//Üye ekleme metodu parametre olarak uye nesnesini alıyor
     {
        FileWriter writer=null;
        writer=new FileWriter("Normal_Üye.txt",true);
        try {
            writer.write(normalUyead.get(normalUyead.size()-1)+"\t"+(normalUyesoyad.get(normalUyesoyad.size()-1)+"\t"+(normalUyemail.get(normalUyemail.size()-1)))+"\n");
        } //Arraylistin son elemanını dosyaya yazıyor /t ile aralına tab atıyor \n ile yeni veri için imleci alt satıra alıyor
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
