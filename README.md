# ☕ Kopi dan Nyemil

> Get a taste of your wish

Aplikasi mobile Android untuk memesan kopi dan makanan ringan, dibuat sebagai tugas mata kuliah **Pengembangan Aplikasi Mobile** berdasarkan wireframe "Kopi dan Nyemil".

## Deskripsi Aplikasi

Kopi dan Nyemil adalah aplikasi pemesanan kopi dan camilan. Pengguna dapat mendaftar atau masuk, melihat daftar menu makanan dan minuman, mengubah nama profil, mengisi alamat pengiriman, lalu mengonfirmasi pesanan. Aplikasi tidak memakai database; data menu berupa data statis (dummy data) dan data pengguna disimpan sementara di memori selama aplikasi berjalan.

| No | Layar | Deskripsi | Status |
|----|-------|-----------|--------|
| 1 | Splash / Welcome | Logo cangkir, animasi masuk, tagline, tombol "Start now" | ✅ |
| 2 | Sign Up | Pilihan Register atau Login dengan kartu keunggulan | ✅ |
| 3 | Login | Input username dan password, validasi, tampilkan/sembunyikan password | ✅ |
| 4 | Register | Nama lengkap, username, password, konfirmasi password dengan validasi | ✅ |
| 5 | Home | Sapaan nama depan, banner, pencarian, kategori, daftar 5 menu, tombol tambah ke keranjang | ✅ |
| 6 | Profile | Ubah nama pengguna dan simpan | ✅ |
| 7 | Alamat Pengiriman (Order) | Ringkasan pesanan, subtotal, ongkir, form alamat, metode pembayaran | ✅ |
| 8 | Konfirmasi Pesanan | Nomor pesanan, pembayaran, total, alamat, tombol "Oke" ke Home | ✅ |

### Fitur Tambahan

- Pencarian menu secara langsung
- Filter kategori (Semua, Minuman, Makanan)
- Keranjang dengan pengatur jumlah (− / +) dan bar total harga
- Pilihan metode pembayaran (COD, QRIS, Transfer bank)
- Akun tersimpan di perangkat dengan SharedPreferences
- Animasi Splash dan transisi antar layar

### Daftar Menu (Dummy Data)

| Menu | Deskripsi | Harga |
|------|-----------|-------|
| Kopi Susu Gula Aren | Espresso, susu, gula aren | Rp 22.000 |
| Donat Cokelat | Donat empuk, glaze cokelat | Rp 12.000 |
| Sourdough Loaf | Roti fermentasi alami | Rp 35.000 |
| Cappuccino | Espresso, foam susu lembut | Rp 25.000 |
| Matcha Latte | Matcha Jepang, susu segar | Rp 27.000 |

### Alur Aplikasi

```
Splash → Sign Up → Register / Login → Home → Order (Alamat) → Konfirmasi → Home
                                         └→ Profile
```

## Teknologi yang Digunakan

- **Bahasa**: Kotlin
- **IDE**: Android Studio
- **UI**: XML Layout (ConstraintLayout)
- **View Binding** untuk akses komponen UI
- **RecyclerView** untuk daftar menu
- **Material Components**
- **Min SDK**: API 27 (Android 8.1)
- **Penyimpanan data**: dummy data & `object` di memori (tanpa database)
- **SharedPreferences** untuk menyimpan akun pengguna
- **ShapeableImageView** dan drawable vector untuk tampilan

## Cara Menjalankan Aplikasi

1. Pastikan Android Studio sudah terpasang.
2. Clone repository:
   ```bash
   git clone https://github.com/faizmmly/Kopi-dan-Ngemil.git
   ```
3. Buka folder project di Android Studio (**File → Open**).
4. Tunggu proses **Gradle Sync** selesai.
5. Hubungkan HP Android (aktifkan USB Debugging) atau buat emulator di **Device Manager**.
6. Klik tombol **Run ▶**.

## Screenshot

| Splash | Sign Up | Login | Register |
|:------:|:-------:|:-----:|:--------:|
| _segera_ | _segera_ | _segera_ | _segera_ |

| Home | Profile | Alamat | Konfirmasi |
|:----:|:-------:|:------:|:----------:|
| _segera_ | _segera_ | _segera_ | _segera_ |

## Identitas

- **Nama**: Faiz Muhammad Ilham
- **NIM**: 1247050032
- **Mata Kuliah**: Pengembangan Aplikasi Mobile
- **Dosen Pengampu**: H.,Aldy Rialdy Atmadja,M.T 