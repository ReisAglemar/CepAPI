package edu.reis;

import com.google.gson.Gson;
import edu.reis.model.Endereco;
import edu.reis.service.Iuri;
import edu.reis.service.RecordEndereco;
import edu.reis.service.Requisao;
import edu.reis.service.Uri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<>();
        int op;

        do {

            System.out.print("Informe o cep: ");
            String cep = sc.nextLine();

            Iuri iuri = new Uri(cep);
            Requisao requisao = new Requisao(iuri);
            Gson gson = new Gson();
            RecordEndereco recordEndereco = gson.fromJson(requisao.getJson(), RecordEndereco.class);
            Endereco endereco = new Endereco(recordEndereco);
            enderecos.add(endereco);

            System.out.print("Adicionar Outro Cep (S=1/N=0): ");
            op = sc.nextInt();
            sc.nextLine();
        }
        while (op != 0);

        for (Endereco enderecoEndereco : enderecos) {
            System.out.println(enderecoEndereco.Info());
        }
        sc.close();
    }
}