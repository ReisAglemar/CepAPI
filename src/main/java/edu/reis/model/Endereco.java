package edu.reis.model;

import edu.reis.service.RecordEndereco;

public class Endereco {

    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String ddd;

    public Endereco(RecordEndereco recordEndereco) {
        this.cep = recordEndereco.cep();
        this.estado = recordEndereco.estado();
        this.cidade = recordEndereco.localidade();
        this.bairro = recordEndereco.bairro();
        this.rua = recordEndereco.logradouro();
        this.ddd = recordEndereco.ddd();
    }

    public String Info() {

        if (cep != null) {
            return """
                    
                        Endereço Localizado:
                    
                        Cep: %s
                        Estado: %s
                        Cidade: %s
                        Bairro: %s
                        Rua: %s
                        DDD: %s
                    
                    """.formatted(cep, estado, cidade, bairro, rua, ddd);
        }

        return """
                
                    Erro ao Procurar o Endereço!
                    Verifique o Cep Informado.
                
                """;
    }
}
