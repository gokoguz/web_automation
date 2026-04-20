TC ID: 1
Modül: Login
Başlık: Geçerli kullanıcı ile başarılı giriş
Ön Koşul: Kullanıcı kayıtlı olmalı
Test Tipi: Positive

Adımlar:
1. Login sayfasına git
2. username: standard_user gir
3. password: secret_sauce gir
4. Login butonuna tıkla

Beklenen:
Products sayfasına yönlendirilir


TC ID: 2
Modül: Login
Başlık: Hatalı şifre ile giriş
Ön Koşul: 
Test Tipi: Negative

Adımlar:
1. Username doğru gir
2. Yanlış password gir
3. Login butonuna tıkla

Beklenen:
Error message: "Username and password do not match"



TC ID: 3
Modül: Login
Başlık: Boş alan ile login
Ön Koşul: 
Test Tipi: Boundary

Adımlar:
1. Username boş bırak
2. Password boş bırak
3. Login butonuna tıkla

Beklenen:
Error message: "Validation error" gösterilir


TC ID: 4
Modül: Cart
Başlık: Sepete ürün ekleme
Ön Koşul: 
Test Tipi: Positive

Adımlar:
1. Ürün listesine git
2. Bir ürün seç
3. Add to cart tıkla

Beklenen:
Cart counter = 1

TC ID: 5
Modül: Cart
Başlık: Login olmadan sepete ekleme
Ön Koşul: 
Test Tipi: Negative

Adımlar:
1. Logout ol
2. Add to cart tıkla

Beklenen:
Login sayfasına yönlendirir veya hata alınır


TC ID: 6
Modül: Checkout
Başlık: Başarılı checkout işlemi
Ön Koşul: 
Test Tipi: Negative

Adımlar:
1. Sepete ürün ekle
2. Checkout tıkla
3. Bilgileri doldur
4. Continue + Finish

Beklenen:
Order confirmation sayfası


TC ID: 7
Modül: Checkout
Başlık: Boş form ile devam etme
Ön Koşul: 
Test Tipi: Negative

Adımlar:
1. Formu boş bırak
2. Devam butonuna bas

Beklenen:
Validation error alınır


TC ID: 8
Modül: Product
Başlık: Price low to high sıralaması
Ön Koşul: 
Test Tipi: Positive

Adımlar:
1. Sort dropdown butonuna tıkla
2. "Price (low to high)" seç

Beklenen:
Fiyatlar artan şekilde sıralanır