package br.com.jorge.quarkus;

public class PessoaDTO {

    private String nome;
    private String email;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
