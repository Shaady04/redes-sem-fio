package projetoredes.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CamadaEnlace extends ArrayslistsCompartilhadas  {
    public int backOff;
    public boolean inBackOff;
    public boolean acessoAoMeio;
    public CamadaFisica camadaFisica;
    public List<Packages> packagesLidosLista = new ArrayList<Packages>();

    Random random = new Random();

    public CamadaEnlace(CamadaFisica camadaFisica, List<Packages> packagesLidosLista) {
        this.camadaFisica = camadaFisica;
        this.backOff = 0;
        this.acessoAoMeio = true;
        this.inBackOff = false;
        this.packagesLidosLista = packagesLidosLista;
    }
    /*-------------------------------------------------------------------------------------------------*/

    //Detectando acesso ao meio
    public boolean verificaAcessoAoMeio() {
        if(this.camadaFisica.packagesRecebidosLista == null) {
            return true;
        }else {
            return false;
        }
    }
    /*-------------------------------------------------------------------------------------------------*/

    //Printa as Colisoes
    public void printColisoes(int identificador) {
        System.out.println("Colisao detectada para NO (host) de Identificador:" + identificador);
    }
    /*-------------------------------------------------------------------------------------------------*/

    //Printa o backOff
    public void printBackOff(int identificador, int backOff) {
        System.out.println("[ Identificador :" + identificador + " Host em BackOff = " + backOff + "]");
    }
    /*-------------------------------------------------------------------------------------------------*/

    //Envia os pacotes ( camada de acesso ao meio - enlace )
    public void enviaPackage() {
        this.acessoAoMeio = this.verificaAcessoAoMeio();
        if(this.camadaFisica = this.acessoAoMeio) { //se esta livre ao acesso
           if(this.camadaFisica.packagesEnviosLista != null) { //se lista de envios de pacotes estiver vazia
               if(this.backOff == 0) { //se o host encontrasse em backOff
                    this.camadaFisica.enviaPackageCF(); //envio via camada fisica
               } else {
                   ProxEnvioList.add(this.camadaFisica.identificador);//add host na fila --> lista de proximos a enviar
                   this.backOff = (this.backOff-1);
               }
           }
           //se o acesso ao meio n estiver vazio
            else{
               if(this.camadaFisica.packagesEnviosLista != null) {
                   if(this.backOff == 0){
                       this.backOff = random.nextInt(10); //no fica em backoff aleatorio
                       this.printBackOff(this.camadaFisica.identificador, this.backOff); //exibe na tela o backOff
                       ProxEnvioList.add(this.camadaFisica.identificador);
                   }
               }
           }

        }
    }
    /*-------------------------------------------------------------------------------------------------*/

    //add package p / camada fisica
    public void addPackageCE(Packages packages, int macdeDestino) {
        Header header = new Header("enlace", this.camadaFisica.identificador, macdeDestino, 0, -1, -1, -1);
        packages.headerList.add(header);
        this.camadaFisica.packagesEnviosLista.add(packages);
    }
    /*-------------------------------------------------------------------------------------------------*/
}
