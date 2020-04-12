package projetoredes.executavel;

import projetoredes.classes.*;

import java.util.Random;

public class play extends Host{



    public play(int identificador, int distX, int distY, int tamRaio) {
        super(identificador, distX, distY, tamRaio);

    }

    Random random = new Random();


    public void gerarHosts() {
        for(int i = 5; i < 11; i++){
            distX = random.nextInt(10);
            distY = random.nextInt(10);
            tamRaio = random.nextInt(15);
            identificador = i;
         Host host = new Host(identificador, distX, distY, tamRaio);
        }
    }

    public static Host gerarHostsProntos(){
        new Host(0, 1, 3,5);
        new Host(1, 2, 1,4);
        new Host(2, 2, 2,3);
        new Host(3, 3, 2,5);
        new Host(4, 1, 2,4);
    }

    public void simulator(){
        for(int j = 0; j < hostsList.size(); j++){
            int probNumPackages = random.nextInt(50); //numero escolhido aleatoriamente para prob criacao de packages
            int number = hostsList.size();
            number =-1;
            int send = random.nextInt((number); //numero randomico com limite max referente ao numero de hosts na lista
        }

        if(ProxEnvioList != null) {
            for(int k =0; k < ProxEnvioList.size(); k++){
                ProxEnvioList.add(ProxEnvioList.get(k));
            }
        }

        //hosts para transmitir
        for(int k = 0; k < hostsList.size();k++){
            Host(CamadaFisica(enviaPackages()));
        }

        //hosts para receber
        for(int k = 0; k < hostsList.size();k++){
            Host(CamadaFisica(enviaPackages()));
        }



    }

    public void main(String[] args) {
            gerarHosts();
            gerarHostsProntos();
            simulator();

    }
}
