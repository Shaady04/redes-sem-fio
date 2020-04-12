package projetoredes.classes;

public class Host extends ArrayslistsCompartilhadas {
    public int identificador;   //id do hospedeiro;
    public String hospedeiro;
    public String camadaRede;
    public int distX;
    public int distY;
    public int tamRaio;

    public Host(int identificador, int distX, int distY, int tamRaio) {
        this.identificador = hostsList.size();
        this.distX = distX;
        this.distY = distY;
        this.tamRaio = tamRaio;
        this.camadaRede = CamadaRede(CamadaEnlace(CamadaFisica(this.identificador, this.distX, this.distY, this.tamRaio)));
        hostsList.add(this);
        System.out.println("No hospedeiro: " + this.identificador + " , x: " + this.distX +
                " , y: " + this.distY + " , raio: " + this.tamRaio);
    }
    /*-------------------------------------------------------------------------------------------------*/

    public void criaPackages(String macdeDestino, String mensagem, Double duracao) {
        identificador = this.camadaRede.camadaEnlace.camadaFisica.identificador;

        System.out.println("[ No hospedeiro: " + this.identificador + " | Package | Origem: " + this.identificador +
            " | Destino: " + macdeDestino + " | tempo de duracao: " + duracao + " | Msg: " + mensagem);

        this.camadaRede.addPackage(macdeDestino, mensagem, duracao);
    }
}
