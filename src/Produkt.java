import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Produkt {
    //1-) burada oncelikle urunun tanimlamasi  yapilir. id urunIsmi uretici miktar birim ve raf (6 adet fields mevcut)

    int produktID=0;
    String produktName;
    String hersteller;
    double mange=0;
    String einheit;
    int regalNo=0;

    public int getProduktID() {
        return produktID;
    }

    public void setProduktID(int produktID) {
        //produktID++;
        this.produktID = produktID;
    }
    public Produkt(){

    }

    public Produkt(int produktID, String produktName, String hersteller, double mange, String einheit, int regalNo) {
        this.produktID=produktID;
        this.produktName = produktName;
        this.hersteller = hersteller;
        this.mange = mange;
        this.einheit = einheit;
        this.regalNo = regalNo;
    }

    public Produkt(int produktID,String produktName, String hersteller, String einheit) {
        this.produktID=produktID;
        this.produktName = produktName;
        this.hersteller = hersteller;
        this.einheit = einheit;
    }
    @Override
    public String toString() {
        return "Produkt{" +
                ",produkt Id='"+produktID+ '\'' +
                "produktName='" + produktName + '\'' +
                ", hersteller='" + hersteller + '\'' +
                ", mange=" + mange +
                ", einheit='" + einheit + '\'' +
                ", regalNo=" + regalNo +
                '}';
    }
}
