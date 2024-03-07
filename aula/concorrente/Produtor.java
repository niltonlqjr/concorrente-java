package aula.concorrente;

import java.util.Random;

public class Produtor extends Thread{
    private Buffer b;
    private int menor, maior;
    
    private int produzir(){
        int x;
        Random rand = new Random();
        x = rand.nextInt(this.maior - this.menor + 1) + this.menor;
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
        }
        System.out.println("Produzido " + x);
        return x;
    }
    
    public Produtor(Buffer b, int menor, int maior){
        this.b = b;
        this.menor = menor;
        this.maior = maior;
    }
    
    @Override
    public void run(){
        int x;
        while(true){
            x = this.produzir();
            b.insere(x);
            System.out.println("inseriu "+ x);
        }
    }
}
