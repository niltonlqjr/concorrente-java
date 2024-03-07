package aula.concorrente;

public class Concorrente {
    public static void main(String[] args) throws InterruptedException {
        Buffer buf;
        Produtor p;
        Consumidor c;
        float multiplicador;
        int tam_buff;
        try{
            multiplicador = Float.parseFloat(args[0]);
        }catch(IndexOutOfBoundsException ex){
            multiplicador = 1;
        }

        try{
            tam_buff = Integer.parseInt(args[1]);
        }catch(IndexOutOfBoundsException ex){
            tam_buff = 10;
        }
        
        System.out.println("multiplicador:"+multiplicador);
        System.out.println("tamanho do buffer:"+tam_buff);
        buf = new Buffer(tam_buff);
        p = new Produtor(buf, 100, 5000);
        c = new Consumidor(buf, multiplicador);
        
        c.start();
        p.start();
        
        c.join();
        p.join();
    }
}
