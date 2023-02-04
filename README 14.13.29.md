# Tugas Besar 2 - Web Services Using SOAP and REST
Dorayaki Supplier<br>
IF3110 - Pengembangan Perangkat Lunak Berbasis Web

## Author
- Shifa Salsabiila (13519106)
- Ryo Richardo (13519193)
- Andres Jerriel Sinabutar (13519218)

## Penjelasan Singkat
Dorayaki Supplier adalah bagian dari sistem DoraStore yang berperan sebagai interface pabrik dengan toko dorayaki. 
Service ini berfungsi sebagai interface yang menghubungkan Toko dan backend pabrik. 
Service ini dibangun dengan protokol SOAP dalam Java Servlet dengan menggunakan JAX-WS. 
Database dibangun dengan menggunakan PostgreSQL yang di-*deploy* di cloud.

## Requirements
1. [Java 8](https://www.java.com/en/)

## Cara Instalasi
1. Clone repository ini dengan menggunakan `git clone` via HTTP atau SSH.
2. Lengkapi requirements yang disebutkan pada bagian sebelumnya.
3. Buka Terminal (jika menggunakan Linux atau MacOS) atau Command Prompt (jika menggunakan Windows). Lalu, navigasi menuju direktori folder dimana Anda mengunduh atau meng-*clone* repositori ini.
4. Navigasi menuju direktori com/wbd/dorayakisupplier dan jalankan `javac DorayakiSupplierServicePublisher`
5. Jalankan aplikasi dengan perintah `java DorayakiSupplierServicePublisher`
6. Server akan dijalankan pada `localhost:8081/dorayakisupplierservice`


## Pembagian Tugas
**SOAP**
| Fitur  | 13519106 | 13519193 | 13519218 |
| --- | --- | --- | --- |
| Melakukan request pengiriman dorayaki (penambahan stok) | :white_check_mark: |  | :white_check_mark: |
| Membaca status request pengiriman yang dilakukan toko tersebut   |  | :white_check_mark: |  :white_check_mark:|
| Membaca varian dorayaki yang disediakan pabrik   |  |  | :white_check_mark: |
| Melakukan pembatasan request   |  |  | :white_check_mark: |
