package br.com.jhegnerlabs.fixturefactory;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Endereco {

    private String id;
    private String rua;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    public Endereco() {
    }

    public Endereco(String id, String rua, String cidade, String estado, String pais, String cep) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
