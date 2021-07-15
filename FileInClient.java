package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Ingrese la contraseña");
        String password = scaner.next();
        System.out.println("Ingrese el usuario");
        String user = scaner.next();
        System.out.println("Ingrese la ip");
        String ip = scaner.next();
        System.out.println("Contraseña: "+password+ " usuario: "+user+" ip: "+ip);
        try {
            Process process = Runtime.getRuntime().exec("sshpass -p "+password+" ssh "+user+"@"+ip+" 'bash -s' < buscador.sh");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}