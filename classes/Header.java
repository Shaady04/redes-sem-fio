package projetoredes.classes;

import java.util.List;

public class Header {
    public String tipoCabecalho;
    public int macdeOrigem;
    public int macdeDestino;
    public int numero;
    public int requisicao;
    public int sequenciadeNumeros;
    public List sequenciadaLista;

    public String destinoId;
    public String remetenteId;

    public Header(String tipoCabecalho, String destinoId, String remetenteId){
        this.tipoCabecalho = tipoCabecalho;
        this.destinoId = destinoId;
        this.remetenteId = remetenteId;
    }

    public Header(String tipoCabecalho, int macdeOrigem, int macdeDestino, int numero, int requisicao, int sequenciadeNumeros, List sequenciadaLista) {
//        this.tipoCabecalho = tipoCabecalho;
//        this.macdeOrigem = macdeOrigem;
//        this.macdeDestino = macdeDestino;
//        this.numero = numero;
//        this.requisicao = requisicao;
//        this.sequenciadeNumeros = sequenciadeNumeros;
//        this.sequenciadaLista = sequenciadaLista;

        //cabeçalho para enlace
        if(tipoCabecalho == "enlace") {
            this.tipoCabecalho = "enlace";
            this.macdeOrigem = macdeOrigem;
            this.macdeDestino = macdeDestino;
            this.numero = numero;
        } else {
            //cabeçalho da camada de rede
            this.tipoCabecalho = "rede";
            this.macdeDestino = macdeDestino;
            this.requisicao = requisicao;
            this.sequenciadeNumeros = sequenciadeNumeros;
            this.sequenciadaLista = sequenciadaLista;
        }
    }

//    public String getTipoCabecalho() {
//        return tipoCabecalho;
//    }
//
//    public void setTipoCabecalho(String tipoCabecalho) {
//        this.tipoCabecalho = tipoCabecalho;
//    }
//
//    public String getMacdeOrigem() {
//        return macdeOrigem;
//    }
//
//    public void setMacdeOrigem(String macdeOrigem) {
//        this.macdeOrigem = macdeOrigem;
//    }
//
//    public String getMacdeDestino() {
//        return macdeDestino;
//    }
//
//    public void setMacdeDestino(String macdeDestino) {
//        this.macdeDestino = macdeDestino;
//    }
//
//    public Double getNumero() {
//        return numero;
//    }
//
//    public void setNumero(Double numero) {
//        this.numero = numero;
//    }
//
//    public String getRequisicao() {
//        return requisicao;
//    }
//
//    public void setRequisicao(String requisicao) {
//        this.requisicao = requisicao;
//    }
//
//    public Double getSequenciadeNumeros() {
//        return sequenciadeNumeros;
//    }
//
//    public void setSequenciadeNumeros(Double sequenciadeNumeros) {
//        this.sequenciadeNumeros = sequenciadeNumeros;
//    }
//
//    public Double getSequenciadaLista() {
//        return sequenciadaLista;
//    }
//
//    public void setSequenciadaLista(Double sequenciadaLista) {
//        this.sequenciadaLista = sequenciadaLista;
//    }
}
