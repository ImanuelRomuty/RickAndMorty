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

##FLOW
Rick and Morty flow (1).png
---

## Instalasi

1. **Clone repositori:**
   ```bash
   git clone https://github.com/ImanuelRomuty/RickAndMorty.git
   cd RickAndMorty


