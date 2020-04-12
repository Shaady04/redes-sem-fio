package projetoredes.classes;

import java.util.ArrayList;
import java.util.List;

public class Packages extends ArrayslistsCompartilhadas {
    public int idPacote;       //identifica o pacote
    public String dadosDaMsg;     //mensagem transmitida
    public Double duracaoTime;        //tempo gasto pela msg em unid de tempo
    public List<Header> headerList = new ArrayList<Header>(); //lista dos headers
    public Header header;

    public Packages(String dadosDaMsg, Double duracaoTime) {
        this.idPacote = -1;
        this.dadosDaMsg = dadosDaMsg;
        this.duracaoTime = duracaoTime;
        this.headerList = headerList;
        this.header = header;
    }
    /*-------------------------------------------------------------------------------------------------*/

    //exibe o pacote
    public void printPackage() {
        System.out.println("Dados do pacote:" + this.dadosDaMsg);
    }
    /*-------------------------------------------------------------------------------------------------*/

    //Adição de headers na lista de headers
    public void adicionaHeaderList(Header header) {
        this.headerList.add(header);
    }
    /*-------------------------------------------------------------------------------------------------*/

    //retorna o pacote com um  pacote novo criado
    public Packages novoPackages(String dadosdaMsg, Double duracaoTime) {
        return Packages(String dadosdaMsg, Double duracaoTime);
    }
    /*-------------------------------------------------------------------------------------------------*/

    public Header getHeaderCR() {
        for (int i = 0; i < headerList.size(); i++) {
            if (header.tipoCabecalho == "rede") {
                return header;
            }
        }
    }
    /*-------------------------------------------------------------------------------------------------*/

    public Header getHeaderCE() {
        for (int i = 0; i < headerList.size(); i++) {
            if (header.tipoCabecalho == "enlace") {
                return header;
            }
        }
    }
    /*-------------------------------------------------------------------------------------------------*/

    public void attSequencia(String sequencia) {
        for(int i = 0; i< headerList.size(); i++) {
          if(header.tipoCabecalho == "rede") {
              header.sequenciadaLista = sequencia;
          }
        }
    }
    /*-------------------------------------------------------------------------------------------------*/
}