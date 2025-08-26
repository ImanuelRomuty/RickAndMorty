# RickAndMorty Android App

Aplikasi Android untuk menampilkan daftar karakter dari serial **Rick and Morty** menggunakan **API publik Rick and Morty**. Aplikasi ini menggunakan arsitektur modern dengan **MVVM**, **Room Database**, **Paging 3**, **Koin** untuk Dependency Injection, dan **Jetpack Compose** untuk UI.

---

## Fitur Utama

1. **Daftar Karakter**  
   - Menampilkan semua karakter dari API Rick and Morty.  
   - Mendukung **scrolling halaman (paging)** dengan Paging 3.  
   - Data disimpan secara lokal di **Room Database** sehingga bisa diakses **offline**.

2. **Detail Karakter**  
   - Menampilkan informasi lengkap seperti nama, status, jenis, gender, asal, lokasi, episode, dan gambar.  
   - Gambar karakter dapat dilihat bahkan ketika **offline**.

3. **Pencarian Karakter**  
   - Cari karakter berdasarkan nama 

4. **Offline Support**  
   - Semua karakter yang sudah diambil dari API akan tersimpan di **Room**.  
   - Pengguna tetap bisa melihat karakter dan detail meskipun **tidak ada koneksi internet**.

5. **Modern UI**  
   - Dibuat menggunakan **Jetpack Compose**.  


---


---

## Teknologi yang Digunakan

- **Kotlin**  
- **Jetpack Compose** (UI Modern)  
- **MVVM Architecture**  
- **Room Database** (Offline Cache)  
- **Paging 3** (Data Pagination)  
- **Retrofit** (HTTP Client)  
- **Koin** (Dependency Injection)  
- **Coil** (Image Loading)  
- **Coroutines + Flow** (Asynchronous Programming)

## FLOW
<img width="792" height="341" alt="Rick and Morty flow (1)" src="https://github.com/user-attachments/assets/97899338-e000-43e8-abd5-4ba4625019cf" />

## Konfigurasi Tambahan

1. Pastikan perangkat/emulator memiliki koneksi internet pada pertama kali membuka aplikasi untuk mengambil data dari API.
2. Data akan tersimpan di Room, sehingga saat offline, kamu tetap bisa membuka daftar dan detail karakter.
3. Gambar karakter diambil langsung dari URL API dan di-cache oleh Coil.

## Cara Menggunakan

1. Buka aplikasi → daftar karakter muncul.
2. Scroll ke bawah untuk memuat halaman berikutnya.
3. Ketuk karakter → buka halaman detail dengan informasi lengkap.
4. Gunakan kotak pencarian di atas untuk mencari karakter berdasarkan nama.

# Catatan Penting
1. Fitur pencarian offline masih terbatas, hanya bisa mencari karakter yang sudah tersimpan di database.
2. Detail karakter bisa diakses offline karena data tersimpan di Room Database.
3. Aplikasi ini menggunakan API publik, sehingga jumlah data mungkin terbatas.

# API
1. Link Publik API Rick and Morty : https://rickandmortyapi.com/
---

## Instalasi

1. **Clone repositori:**
   ```bash
   git clone https://github.com/ImanuelRomuty/RickAndMorty.git
   cd RickAndMorty

2.Buka proyek di Android Studio.

3.Sync Gradle untuk memastikan semua dependensi terunduh.

4.Jalankan aplikasi di emulator atau perangkat fisik.


