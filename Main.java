/*

Bu derste, LinkedListler ile ilgili karşılaşabileceğimiz sıkıntıyı bir proje üzerinden ele alacağız.
Detaylar ile ilgili bir ders olacak.
Şehir Turu Programı yazacağız.

 */


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void islemleri_bastir() { //6

        System.out.println("0 - İşlemleri Görüntüle..");
        System.out.println("1 - Bir Sonraki Şehre Git...");
        System.out.println("2 - Bir Önceki Şehre Git...");
        System.out.println("3 - Uygulamadan Çık.");

    }
    public static void sehirleri_turla(LinkedList<String> sehirler) { // Fonksiyonumuzu yazdık. //3

        ListIterator<String> iterator = sehirler.listIterator(); // ListIterator oluşturduk. Listede tek tek gezebilmek için. //4

        int islem;

        islemleri_bastir(); // Mu metodu yazdıktan sonra yukarıda main metodu dışında bu metodun içeriğini yazdık. //5

        Scanner scanner = new Scanner(System.in); //8

        if (!iterator.hasNext()) { /* Liste başındayken bir sonraki adımın doluluğunu kontrol ediyoruz. Başına not koyduk.
                                      Normalde "Bir sonraki adımın içeriği dolu mu?" sorusu başına not koyunca bu sefer
                                      "Bir sonraki adımın içeriği boş mu?" oldu. Boş ise true dönecek.*/ //9
            System.out.println("Herhangi bir şehir bulunmuyor.");

        }
        boolean cikis = false; /* Dolu ise bu kısımdan devam edecek. Değeri false olan cikis değişkenini tanımladık.
                                  Hemen aşağıda başlattığımız while döngüsü içerisinde başına not getirerek true bir
                                  form kazandıracağız. While true döngüsü olmuş olacak.*/ //10
        boolean ileri = true; /* Uygulamayı çalıştırdığımızda 1 ve 2 komutlarını kullandığımızda aynı şehrin çıktısını
                                 iki defa görüyorduk. Bunun sebebi de iteratörün nesneyi geçip bir sonraki nesne referansı
                                 noktasında durduktan (Görsel anlatımdan hatırla. Nesne kutucuğunun hemen yanındaki referans
                                 noktası) sonra geriye git dediğimizde bulunduğu referans noktasından az önce geçtiği nesnenin
                                 üzerine tekrar geliyor. Yani Ankaradan Eskişehire gidiyoruz. Iterator Eskişehiri geçerek
                                 hemen yanında bulunan noktaya, bir sonraki şehir olan Afyonun referans noktasına geliyor.
                                 Bir Önceki Şehre Geri git komutunu verince de Ankara yazması gerekirken Eskişehir yazıyor.
                                 2. kez "Bir Önceki Şehire Git" komutunu verdiğimizde ancak Ankara çıktısını alıyoruz.
                                 Bu detay bir hata ve bunun önüne geçmek için bu eklemeyi yaptık. Aşağıdaki Switch Case
                                 döngüsünde Case 1 ve Case 2 durumlarında ekleme yapacağız. */ //16

        while(!cikis) { //11

            System.out.println("Bir işlem seçiniz: ");

            islem = scanner.nextInt();

            switch(islem) { //12
                case 0:
                    islemleri_bastir();
                    break;
                case 1:
                    if (!ileri) { /* Bu koşulu çıktıda ikileme hatası olduktan sonra ekledik. Normalde tek ilerleme vardı.
                                     Tekrar yazdığımız bu if koşulu ile iki kere ilerlemiş olduk. */ //17
                        if (iterator.hasNext()) {

                            iterator.next();

                        }
                        ileri = true; //18
                    }
                    if (iterator.hasNext()) { //14

                        System.out.println("Şehre gidiliyor : " + iterator.next());

                    }
                    else {
                        System.out.println("Gidilecek Şehir Kalmadı...");
                        ileri = true; // Son olarak bunu yazdık. //21
                    }
                    break;
                case 2:
                    if (ileri) { /* Hata sonrası ikinci eklememiz. Bu if koşulu ile, uygulamada bir adımda iki kere geri
                                    gitmiş olacağız. Bundan dolayı şehirler iki kere gözükmemiş olacak. */ //19

                        if(iterator.hasPrevious()) {

                            iterator.previous();

                        }
                        ileri = false; //20
                    }

                    if (iterator.hasPrevious()) { //15

                        System.out.println("Şehre gidiliyor : " + iterator.previous());

                    }
                    else {
                        System.out.println("Şehir Turu Başladı...");
                    }
                    break;

                case 3:
                    cikis = true; // While döngüsünden çıkmak için cikis'i true yaptık. //13
                    System.out.println("Uygulamadan çıkılıyor...");
                    break;
            }

        }

    }


    public static void main(String[] args) {

        LinkedList<String> sehirler = new LinkedList<String>(); // LinkedList oluşturduk. //1

        sehirler.add("Ankara"); // Oluşturmuş olduğumuz boş vaziyetteki sehirler LinkedList obje referansına şehirleri ekledik. //2
        sehirler.add("Eskişehir");
        sehirler.add("Afyon");

        sehirleri_turla(sehirler); // Listeyi görmek için metod çağrısı yaptık ve programı ilk kez çalıştırdık. //7


    }

}