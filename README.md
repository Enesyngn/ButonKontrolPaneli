# Buton Kontrol Paneli

Bu Java Swing uygulaması, 4x4 bir düzende bulunan butonların aktif ve inaktif olma durumunu ele alır.Basit olarak anlatmak gerekirse seçilen butonlar aktif hale gelirken yani yeşil renkte olurken seçilmeyen butonlar yani inaktif olan butonlarınise sarı olmasını sağlayan bir uygulamadır.

### Özellikler
1. Java Swing kullanılarak bir JFrame içinde 4x4 düzeninde butonlar tasarlandı.
1. Her bir buton, standart Java GUI JButton sınıfından türetilerek override edildi. Bu sayede her butonun özel davranışları belirlendi.
1. Butonlara, GraphQL şema adresi barındıran özellikler eklendi. Her buton, belirli bir GraphQL şemasına işlem gerçekleştirebilecek.
1. Buton nesnesinin, GraphQL şemasına yazacağı bilgi, bir property olarak ayarlandı. Bu sayede her bir butonun işleyeceği bilgi esnek bir şekilde belirlenebiliyor.
1. Butonların aktif ve pasif renk özellikleri tanımlandı. Başlangıçta butonlar pasif renkte olup, tıklandığında aktif renge dönüşüyor.
1. Her butonun aktif ve pasif simge özellikleri belirlendi. Başlangıçta butonlar pasif simgeyi gösterirken, tıklama sonrasında aktif simgeye geçiyorlar.
1. Butonların text değerleri, renkleri ve simgeleri tasarım esnasında veya runtime anında dinamik olarak oluşturulabilir hale getirildi. Bu sayede kullanıcı etkileşimine göre görsel değişiklikler sağlanabiliyor.
1. Herhangi bir butona tıklandığında, belirlenen GraphQL şemasında bir mutation çalıştırma işlemi gerçekleştirildi. Bu, butonlara basılma olayına bağlı olarak belirtilen şemaya yazılım gerçekleştirmektedir.
### Uygulama Çalıştırılması ve Test Süreci: 
1)Program başlatıldığındaki ilk hali:

![image](https://github.com/BatuhanSeyrek/Coklu_Buton_Java_NesneYonelim/assets/115466293/65c06315-560c-401e-8a2f-63a74696d42b)


2)Seçilen herhangi bir butona tıklandığındaki durum:

![image](https://github.com/BatuhanSeyrek/Coklu_Buton_Java_NesneYonelim/assets/115466293/312195e2-5a56-432e-83e6-d05399e09096)


3)İlk seçilen butondan sonra birden fazla buton seçildiğindeki durum:

![image](https://github.com/BatuhanSeyrek/Coklu_Buton_Java_NesneYonelim/assets/115466293/89cc6d47-13ae-4636-9b17-98b0c16db978)


4)Seçilen butonlardan herhangibiri seçildikten sonra tıklandığında sadece tıklanan aktif kalır:

![image](https://github.com/BatuhanSeyrek/Coklu_Buton_Java_NesneYonelim/assets/115466293/3e6ee7a2-277b-41a9-9926-a2aaaa00e425)


5)En son aktif kalan butonun pasif hale getirilme durumu:

![image](https://github.com/BatuhanSeyrek/Coklu_Buton_Java_NesneYonelim/assets/115466293/65c06315-560c-401e-8a2f-63a74696d42b)


## GraphQL
2012’de Facebook tarafından geliştirilen ve o zamanlar daha çok mobil uygulamalar için kullanılan GraphQL 2015’te open source (açık kaynak kodlu yazılım) hale geldi ve 2016’da GitHub’ın da GraphQL’i kullanmaya başlamasıyla popüler olmaya başladı. 
### GraphQL nedir? 
GraphQL, sunucudan veri çekerken istemcilere tam olarak istediklerini vermeyi öncelik kılan bir sorgulama dilidir. İstemciler, sunucuya bir şema üzerinden hangi alanları istediklerine göre bir sorgu oluşturur. Sunucu, bu sorguyu işler ve yalnızca istenilen verileri yanıt olarak gönderir. Böylece istemciler geri dönecek verinin alanları ve büyüklüğü üzerinde bir kontrole sahip olabilir. Farklı boyutta ekranlar için yeterli ve uygun verilerin dönmesine olanak sağlar. 
### GraphQL’in avantajları nelerdir? 
1. Schema sayesinde API kendini dokümante eder. Swagger gibi ek dokümantasyon aracına ihtiyaç yoktur. Böylelikle servisler arası entegrasyonda kolaylık sağlanır. 

1. Query ile istemcinin yalnızca ihtiyaç duyduğu veriler sorgulanır. Bu sayede overfetch veya underfetch olmadan veri transferi yapılır. 

1. Backend değişikliğine bağımlılığı azaltarak frontend tarafında geliştirmeyi hızlandırır. 

1. Birden fazla GraphQL schema’sı tek bir schema’da birleştirilebilir. 

1. REST’te versiyonlama URL üzerinde v1, v2 gibi belirteçlerle yapılırken GraphQL’de buna ihtiyaç yoktur. Schema’nın güncellenmesi yeterlidir. 

1. JSON ve HTTP standartlarıyla uyumludur.
### GraphQL’in dezavantajları nelerdir? 
1. Tek bir endpoint (uç nokta) kullanılması monitoring (izleme) ve security (güvenlik) konularında dezavantaj oluşturuyor. 

1. Schema oluşturması sebebiyle kullanımı karmaşık olabilir. 

1. Yeni bir teknoloji sayılabileceğinden henüz olgun bir seviyeye ulaşmadı. 

1. N+1 problemine sebep olabiliyor. 

1. Rate limiting (uygulamamızın kaynaklarınıza ne kadar erişebileceğini sınırlama operasyonu)’e ihtiyacı var 

1. Declarative (bildirim) data fetch olduğu için cacheleme (önbellek) işlemi zordur.
### GraphQL ne zaman kullanılmalı? 
1. Eğer uygulamanız, birden fazla kaynaktan veri topluyorsa, farklı veri formatlarına sahipse ve bu verileri birleştirmek için karmaşık sorgular yapmanız gerekiyorsa GraphQL tercih edilebilir. 

1. İstemcilerin ihtiyaç duyduğu verilere göre özelleştirilebilir sorgular yapmak istiyorsanız, GraphQL kullanabilirsiniz. 

1. Backend For Frontend gibi yazılım mimarileri ile uyumlu olduğu için tercih edilebilir. 

1. Service aggregation uygulanan yerlerde kullanılabilir. 

1. Bant genişliğinin önemli olduğu noktalarda kullanılabilir.
