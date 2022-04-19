package ru.netology;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 13301);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String msg;
            while (true) {
                System.out.println("Введите число или end для завершения");
                msg = scanner.nextLine();
                out.println(msg);
                if ("end".equals(msg)) {
                    break;
                }

                System.out.println("Server: " + in.readLine());
            }
        }
    }
}