package projetoredes.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class CamadaRede extends ArrayslistsCompartilhadas {
    public List<Routes> routesLista = new ArrayList<Routes>();
    public List<Integer> RequisitionLista = new ArrayList<Integer>();
    public List<Routes> routesNaoConhecidasLista = new ArrayList<Routes>();
    public List<Packages> packagesLista = new ArrayList<Packages>();

    public CamadaEnlace camadaEnlace;
    public Header header;
    public Routes routes;

    Random random = new Random();

    public CamadaRede(List<Routes> routesLista, List<Integer> RequisitionLista, List<Routes> routesNaoConhecidasLista, List<Packages> packagesLista, CamadaEnlace camadaEnlace) {
        this.routesLista = routesLista;
        this.RequisitionLista = RequisitionLista;
        this.routesNaoConhecidasLista = routesNaoConhecidasLista;
        this.packagesLista = packagesLista;
        this.camadaEnlace = camadaEnlace;
        //this.header = header;

    }
    /*-------------------------------------------------------------------------------------------------*/

    public void enviaReq(int macdeDestino) {
        numSequencial += 1;
        List<Integer> sequencia = new ArrayList<Integer>();
        sequencia.add(this.camadaEnlace.camadaFisica.identificador);
        this.RequisitionLista.add(numSequencial);
        int sequenciadeNumeros = random.nextInt(10000);
        this.RequisitionLista.add(sequenciadeNumeros);

        //criando um pacote e inserindo o header da camada de redes
        header = new Header("rede", this.camadaEnlace.camadaFisica.identificador, macdeDestino, -1, 0, sequenciadeNumeros, sequencia);
        Packages packages = new Packages("", 1.0);

        packages.adicionaHeaderList(header);
        String msg = "Enviando pacote de requisicao ";

        //printa o pacote
        System.out.println("[ Host ID: " + this.camadaEnlace.camadaFisica.identificador + "Mac Destinatário: " + header.macdeDestino
            + "| msg: " + msg);

        this.camadaEnlace.addPackageCE(packages, -1);
    }
    /*-------------------------------------------------------------------------------------------------*/

    public void enviaResp(int macdeDestino, List sequencia, String route) {
        header = new Header("rede", this.camadaEnlace.camadaFisica.identificador, macdeDestino, -1 , -1, -1, sequencia);
        Packages packages = new Packages(route, 1.0);
        packages.adicionaHeaderList(header);

        System.out.println("[ HostId" +this.camadaEnlace.camadaFisica.identificador + "Enviando uma RResp para HostID: " + this.header.macdeDestino);
    }

    /*-------------------------------------------------------------------------------------------------*/
    //Criando package na camada de rede
    public void addPackageCR(int macdeDestino, String mensagem, Double tempo) {
        Packages packages = Packages(String mensagem, Double tempo);
        header = new Header("rede", this.camadaEnlace.camadaFisica.identificador , macdeDestino, -1, -1, -1, null);
        this.packagesLista.add(packages);
    }
    /*-------------------------------------------------------------------------------------------------*/

    //envia pacote da camada de rede
    public void enviaPackages() {
        //existe packages?
        if(this.packagesLista != null) {
            Packages packages = this.packagesLista.get(0);
            header = packages.getHeaderCR();
            String sequencia = null;

            for(int i = 0; i < this.routesLista.size(); i++) {
                if(routes.destino == packages.headerList.get(0).macdeDestino) {
                    sequencia = routes.sequencia;
                    if(this.routesNaoConhecidasLista.contains(packages.headerList.get(0).macdeDestino) == true) {
                        this.routesNaoConhecidasLista.remove(packages.headerList.get(0).macdeDestino);
                    }
                }
            }
            //etapa de verifica rota
            if(sequencia != null){
                packages.attSequencia(sequencia);
                this.packagesLista.remove((packagesLista.size() -1));

                for(EnumeratedItem<Header> headersItem : ListUtils.enumerate(header)){
                        Enu
                }
            }
        }
    }
    /*-------------------------------------------------------------------------------------------------*/

}
