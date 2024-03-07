/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula.concorrente;
public class Consumidor extends Thread{
    private Buffer b;
    private int x;
    private float fator;
    
    private void consumir(){
        try{
            Thread.sleep((int)this.fator * this.x);
        }catch (InterruptedException ex){
        
        }
        System.out.println("Consumido:" + this.x);
    }
    public Consumidor(Buffer b, float fator){
        this.b = b;
        this.fator = fator;
    }
    
    @Override
    public void run(){
        while(true){
            this.x = b.remove();
            System.out.println("removeu " + this.x);
            this.consumir();
        }
    }
}
