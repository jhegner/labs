package br.com.jhegnerlabs.fixturefactory;

import java.time.LocalDate;
import java.util.Optional;

//@Data
//@AllArgsConstructor
public class Cliente {

    private String id;
    private String nome;
    private String apelido;
    private String email;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private LocalDate dataCadastro;

    public Cliente() {
        super();
    }

    public Cliente(String id, String nome, String apelido, String email, LocalDate dataNascimento, Endereco endereco, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Optional<Endereco> getEnderecoOptional() {
        return Optional.ofNullable(this.endereco);
    }
}
