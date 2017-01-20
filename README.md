# Sudoku-Solver

###Hyper Sudoku Solver using Bruteforce Algorithm

Hyper-sudoku adalah adalah varian Sudoku yang paling terkenal. Ia dikenal juga dengan nama "NRC Sudoku", "Windoku", dan  "4 Square Sudoku".  Layout permainan ini mirip dengan sudoku, tetapi dengan penambahan persegi 3 x 3 di dalamnya (diberi arsiran berwarna ungu) dengan syarat semua angka 1 sampai 9 harus muncul di dalam kotak persegi itu. 
Cara permainannya sedikit berbeda dengan sudoku biasa, karena penekanannya pada kotak persegi di dalamnya. Kotak persegi memberikan banyak informasi kepada pemain untuk, secara logika, mengurangi kemungkinan pengisian nilai pada kotak-kotak lain yang tersisa. (Sumber: Wikipedia) 
Kotak-kotak di dalam hyper-sudoku harus diisi dengan angka 1 sampai 9 sedemikian sehingga:
1.	tidak ada angka yang sama (berulang) pada setiap baris;
2.	tidak ada angka yang sama (berulang) pada setiap kolom;
3.	tidak ada angka yang sama (berulang)  pada setiap bujursangkar (persegi) yang lebih kecil.
4.	kotak persegi berwarna ungu berisi angka 1 sampai 9


Dalam program penyelesaian Sudoku ini, dipergunakan Algoritma Brute Force. Algoritma yang digunakan adalah sebagai berikut :
1.	Menulis angka “1” pada cell pertama yang kosong. Kemudian periksa apakah penempatan angka tersebut memenuhi syarat hyper-sudoku
2.	Jika diperbolehkan,, maka maju ke cell selanjutnya yang masih kosong.
3.	Tempatkan kembali angka “1” pada cell tersebut dan kemudian, periksa kembali apakah memenuhi syarat.
4.	Jika tidak memenuhi syarat, berarti angka “1” tidak diperbolehkan. Sehingga coba dengan angka lainnya yaitu “2” atau “3 atau “4” dan seterusnya sampai 9.
5.	Jika penempatan angka tidak ada yang memenuhi satupun angka dari 1-9, maka, tinggalkan cell tersebut, dan mundur ke cell yang sebelumnya diisi. Nilai di cell tersebut diganti dengan nilai yang mungkin dan memenuhi syarat.
6.	Ulangi langkahnya hingga 81 cell terisi semua dengan benar
7.	Jika hingga terakhir masih terdapat cell kosong tetapi tidak bisa diisi dengan angka 1-9, berarti Sudoku tersebut tidak memiliki solusi

