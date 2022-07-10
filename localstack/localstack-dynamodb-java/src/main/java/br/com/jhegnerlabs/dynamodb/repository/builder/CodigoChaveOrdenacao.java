package br.com.jhegnerlabs.dynamodb.repository.builder;

import br.com.jhegnerlabs.dynamodb.enums.EntityType;

public class CodigoChaveOrdenacao {

    private String idProcesso;
    private String processoMetadata;
    private String idDocumento;

    CodigoChaveOrdenacao(String idProcesso, String processoMetadata, String idDocumento) {
        this.idProcesso = idProcesso;
        this.processoMetadata = processoMetadata;
        this.idDocumento = idDocumento;
    }

    public static CodigoChaveOrdenacao.CodigoChaveOrdenacaoBuilder builder() {
        return new CodigoChaveOrdenacao.CodigoChaveOrdenacaoBuilder();
    }

    public static class CodigoChaveOrdenacaoBuilder {

        private String idProcesso = "";
        private String processoMetadata = "";
        private String idDocumento = "";

        CodigoChaveOrdenacaoBuilder() {
        }

        public CodigoChaveOrdenacao.CodigoChaveOrdenacaoBuilder withIdProcesso(String idProcesso) {
            this.idProcesso = EntityType.PROCESSO.name() + "#" + idProcesso;
            return this;
        }

        public CodigoChaveOrdenacao.CodigoChaveOrdenacaoBuilder withProcessoMetadata() {
            this.processoMetadata = "#METADATA#";
            return this;
        }

        public CodigoChaveOrdenacao.CodigoChaveOrdenacaoBuilder withIdDocumento(String idDocumento) {
            this.idDocumento = "#" + EntityType.DOCUMENTO.name() + "#" + idDocumento;
            return this;
        }

        public CodigoChaveOrdenacao build() {
            return new CodigoChaveOrdenacao(this.idProcesso, this.processoMetadata, this.idDocumento);
        }

        @Override
        public String toString() {
            return "CodigoChaveOrdenacaoBuilder{" +
                    "idProcesso='" + idProcesso + '\'' +
                    ", processoMetadata='" + processoMetadata + '\'' +
                    ", idDocumento='" + idDocumento + '\'' +
                    '}';
        }
    }

    // monta o valor da sorted key ou chave de ordenacao
    public String toString() {
        return this.idProcesso + this.processoMetadata + this.idDocumento;
    }
}
