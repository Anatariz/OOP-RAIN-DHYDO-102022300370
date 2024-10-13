package MODUL1;

import java.util.Scanner;

public class EADTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayFlightList();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    displayTicketOrder();
                    break;
                case 4:
                    running = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("====== EAD Ticket Booking System ======");
        System.out.println("1. Tampilkan Daftar Penerbangan");
        System.out.println("2. Beli Tiket");
        System.out.println("3. Tampilkan Pesanan Tiket");
        System.out.println("4. Exit");
        System.out.print("Silahkan pilih menu: ");
    }

    private static void displayFlightList() {
        System.out.println("\n1.");
        System.out.println("Nomor Penerbangan: GA301");
        System.out.println("Bandara keberangkatan: CGK, Jakarta ---> Bandara Tujuan: DPS, Bali");
        System.out.println("Waktu keberangkatan: 08:30 ---> Waktu kedatangan: 09:15");
        System.out.println("Harga Tiket: Rp.1200000.0");

        System.out.println("\n2.");
        System.out.println("Nomor Penerbangan: QZ202");
        System.out.println("Bandara keberangkatan: SUB, Surabaya ---> Bandara Tujuan: MDC, Medan");
        System.out.println("Waktu keberangkatan: 09:00 ---> Waktu kedatangan: 11:45");
        System.out.println("Harga Tiket: Rp.1500000.0");
    }

    private static void buyTicket() {
        System.out.println("\nSilahkan pilih nomor penerbangan (ex: 1): ");
        // In a real implementation, you would handle the ticket purchase logic here
        System.out.println("Pembelian tiket berhasil dilakukan. (Ini hanya simulasi, tidak ada pembelian nyata)");
    }

    private static void displayTicketOrder() {
        System.out.println("\n====== Detail Tiket Penerbangan ======");
        System.out.println("Nomor Tiket Kepenumpukan: 1202220080");
        System.out.println("Nama Depan: IEAD");
        System.out.println("Nama Belakang: LaboratoryKeeper Penerbangan: GA301");
        System.out.println("Bandara keberangkatan: CGK, Jakarta ---> Bandara Tujuan: DPS, Bali");
        System.out.println("Waktu keberangkatan: 08:30 ---> Waktu kedatangan: 09:15");
        System.out.println("Harga Tiket: Rp.1200000.0");
    }
}
