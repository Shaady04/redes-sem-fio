package projetoredes.classes;

import java.util.ArrayList;
import java.util.List;


public class CamadaFisica extends ArrayslistsCompartilhadas {
    public int identificador;
    public Double raio;
    public Double distX;
    public Double distY;
    public Host host;

    public List<List<Packages>> packagesBackupLista = new ArrayList<List<Packages>>();
    public List<Packages> packagesEnviosLista = new ArrayList<Packages>();
    public List<Package> packagesRecebidosLista = new ArrayList<Package>();
    public List<Host> vizinhancaLista = new ArrayList<Host>();

    public CamadaFisica(int identificador, Double raio, Double distX, Double distY, List<List<Packages>> packagesBackupLista, List<Packages> packagesEnviosLista, List<Package> packagesRecebidosLista, List<Host> vizinhancaLista, Host host) {
        this.identificador = identificador;
        this.raio = raio;
        this.distX = distX;
        this.distY = distY;
        this.packagesBackupLista = packagesBackupLista;
        this.packagesEnviosLista = packagesEnviosLista;
        this.packagesRecebidosLista = packagesRecebidosLista;
        this.vizinhancaLista = vizinhancaLista;
        this.host = host;
    }
    /*-------------------------------------------------------------------------------------------------*/

    public boolean calculoDistacia(Double distX1, Double distX2, Double distY1, Double distY2, Double valorRaio) {
        Double distanciaX = distX2 - distX1;
        Double distanciaY = distY2 - distY1;
        Double mod = Math.sqrt((distanciaY * distanciaY) + (distanciaX * distanciaX));
        return (valorRaio >= mod);
    }
    /*-------------------------------------------------------------------------------------------------*/

    public void verificaVizinhanca(){
        for(int i = 0; i < hostsList.size(); i++) {
            if(host.identificador != this.identificador) { //o host n sendo o proprio
                //calculando seu alcance
                if(calculoDistacia(this.distX, this.distY, this.raio, host.camadaRede.camadaEnlace.camadaFisica.distX,
                        host.camadaRede.camadaEnlace.camadaFisica.distY)) { //verifica se ele eh encotrado na lista da vizinhanca
                    if(this.vizinhancaLista.contains(host) == false){ //se esse host n estiver na lista
                        this.vizinhancaLista.add(host);
                    }
                }

            }

        }
    }
    /*-------------------------------------------------------------------------------------------------*/

    //enviando packages via camada fisica
    public void enviaPackageCF() {
        this.verificaVizinhanca();  //add vizinhos na lista
        for(int i = 0; i < vizinhancaLista.size(); i++) { //envia pacote aos vizinhos
            host.camadaRede.camadaEnlace.camadaFisica.receberPacote(this.packagesEnviosLista);
        }
        //add package na lista
        this.packagesBackupLista.add(this.packagesEnviosLista);
    }
    /*-------------------------------------------------------------------------------------------------*/

    public void receberPackage(Package packages) {
        //add na lista compartilhada
        packagesReceberList.add(this.identificador);
        //add na lista de recebidos da classe camadafisica
        this.packagesRecebidosLista.add(packages);
    }
}
