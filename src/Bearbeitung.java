import java.util.*;

public class Bearbeitung<keyList> {
    int produktIdObstGemüse=0;
    int produktIdMetzgerei=100;
    int produktIdLebensMittel=200;
    int produktId=0;
    int regalNo =0;
    int regalNoObstGemüse =0;
    int regalNoMetzgerei =100;
    int regalNoLebensMittel =200;



    Scanner scan =new Scanner(System.in);

    Produkt produkt1 =new Produkt();

    List<Produkt> produktList = new ArrayList<>();
    Map<Integer, List> produktMapList =new HashMap<>();
    List<Object> valuesList =new ArrayList<>();
    public List<Integer> keyList =new ArrayList<>();//bos bir list olust

    public void eingangPanel(){
        System.out.println("Wählen Sie bitte Ihr Prozes aus\nfür ein neus Produkt herstellen : 1\n" +
                "ein Produckt ausdruken : 2\ndie Mange eines Produktes erhöhen : 3\n" +
                "die Mange eines Produktes vermindern : 4\nein Produkt imd Regal ein setzen : 5\nzum Verlassen : 6");
        int prozes = scan.nextInt();
        switch (prozes) {
            case 1:
                produktHersellen();
                entscheidung();
                break;
            case 2:
                produktAusdrucken();
                entscheidung();
                break;
            case 3:
                produktMangeAdd();
                entscheidung();
                break;
            case 4:
                produktMangeMinderung();
                entscheidung();
                break;
            case 5:
                insRegalEinsetzen();
                entscheidung();
                break;
            case 6:
                verlassen();
                break;
            default:
                System.out.println("Sie sollen eine nummer zwieschen 1- 6 aus wählen");
                eingangPanel();
        }
    }

    public  List produktHersellen(){
        int produktID=produktID();
        System.out.println("Geben Sie bitte den Name des Produkts ein ");
        String produktName =scan.next();
        System.out.println("Geben Sie bitte den Hersteller des Produkts ein ");
        String hersteller =scan.next();
        System.out.println("Geben Sie bitte die einheit des Produkts ein ");
        String einheit =scan.next();
        Produkt produkt =new Produkt(produktID,produktName,hersteller,einheit);
        double mange=produkt.mange;
        int regalNo =produkt.regalNo;
        List valuesList =new ArrayList<>(Arrays.asList(produktName, hersteller,mange,einheit,regalNo));
        produktMapList.put(produktID,valuesList);
        System.out.printf("%-6d %-8s %-8s %-6f %-6s %-6d\n",produktID, valuesList.get(0),valuesList.get(1),valuesList.get(2),
                valuesList.get(3),valuesList.get(4) );
        //produktList.add(produkt);
        //System.out.println(produktMapList.toString());
        return valuesList;
    }

    public void insRegalEinsetzen() {
        System.out.println("geben sie bitte Produkt Id ein");
        int eingabeId = scan.nextInt();
        if (produktMapList.containsKey(eingabeId)) {
            if (eingabeId>200){
                regalNoLebensMittel++;
                produktMapList.get(eingabeId).set(4,regalNoLebensMittel);
            }else if (eingabeId>100){
                regalNoMetzgerei++;
                produktMapList.get(eingabeId).set(4,regalNoMetzgerei);
            }else if (eingabeId>0){
                regalNoObstGemüse++;
                produktMapList.get(eingabeId).set(4,regalNoObstGemüse);
            }else {
                System.out.println("das Produkt noch nicht definiert");
                eingangPanel();
            }
        }else System.out.println("das Produckt nicht verfüngbar");
    }
    public void produktMangeAdd(){
        System.out.println("geben sie bitte Produkt Id ein");
        int eingabeId = scan.nextInt();
        if (produktMapList.containsKey(eingabeId)){
            System.out.println("geben Sie bitte die Mange ein");
            double mangeAdd = scan.nextDouble();
            double neuMange = mangeAdd+(Double) produktMapList.get(eingabeId).get(2);
            produktMapList.get(eingabeId).set(2,neuMange);
        }else System.out.println("das Produkt wurde nicht verfüngbar");
    }
    public void produktMangeMinderung(){
        System.out.println("geben sie bitte Produkt Id ein");
        int eingabeId = scan.nextInt();
        if (produktMapList.containsKey(eingabeId)){
            System.out.println("geben Sie bitte die Mange ein");
            double mangeMinderung = scan.nextInt();
            if(mangeMinderung>(Double) produktMapList.get(eingabeId).get(2)){
                System.out.println("leider wir haben nur : "+produktMapList.get(eingabeId).get(2)+
                        produktMapList.get(eingabeId).get(4) );//elimizde kalan ve birimi kg veya lt gibi
                System.out.println("geben Sie bitte andere Mänge ein");
                produktMangeMinderung();
            }else{
                double neuMange = (Double) produktMapList.get(eingabeId).get(2)-mangeMinderung;
                produktMapList.get(eingabeId).set(2,neuMange);
            }
        }else System.out.println("das Produkt wurde nicht verfüngbar");
    }

    public int produktID() {
        System.out.println("geben Sie bitte produksart ein\nfür Obst und Gemüse : 1\nMetzgerei : 2 \nLebensmittel : 3\nZum Verlassen : 4");
        int eingabeID= scan.nextInt();
        if (eingabeID==3){
            produktIdLebensMittel++;
            produktId=produktIdLebensMittel;
        }else if (eingabeID==2){
            produktIdMetzgerei++;
            produktId=produktIdMetzgerei;
        }else if (eingabeID==1){
            produktIdObstGemüse++;
            produktId=produktIdObstGemüse;
        }
         else {
            produktID();
        }
        return produktId;
    }

    public void produktAusdrucken(){
        System.out.println("geben sie bitte Produkt Id ein");
        int eingabeId = scan.nextInt();
        if (produktMapList.containsKey(eingabeId)){
            produktMapList.get(eingabeId).get(0);
            //System.out.println(produktMapList.get(eingabeId));
            System.out.println("Id     Name     Hersteller     Mange     Einheit   RegalNo  ");
            System.out.println("-------------------------------------------------- ");
            System.out.printf("%-6d %-8s %-8s %-10f %-6s %-6d\n",eingabeId, produktMapList.get(eingabeId).get(0),produktMapList.get(eingabeId).get(1),produktMapList.get(eingabeId).get(2),
                    produktMapList.get(eingabeId).get(3),produktMapList.get(eingabeId).get(4) );
        }else System.out.println("das Produkt wurde nicht hergestellt");

    }public void verlassen(){
        System.out.println("Aufwiedersehen");
    }

    public void entscheidung(){
        System.out.println("zum Weitermachen druken Sie bitte : 1\nzum Verlassen druken Sie bitte : 2");
        int entscheidung= scan.nextInt();
        if (entscheidung==1){
            eingangPanel();
        }else if (entscheidung==2){
            verlassen();
        }else {
            System.out.println("Wählen Sie bitte Ihr Wusch aus");
            entscheidung();
        }
    }
}
