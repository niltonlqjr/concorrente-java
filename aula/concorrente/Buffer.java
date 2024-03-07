package aula.concorrente;
import java.util.concurrent.locks.*;

public class Buffer {
    private ReentrantLock lock; 
    private Condition naoCheio, naoVazio;
    private int[] buffer;
    private int ini, fim, tam, tam_max;
    
    public Buffer(int x){
        this.buffer = new int[x];
        this.ini = this.fim= this.tam=0;
        this.tam_max=x;
        this.lock = new ReentrantLock();
        this.naoCheio = lock.newCondition();
        this.naoVazio = lock.newCondition();
    }
    
    public void insere(int x){
        this.lock.lock();
        try {
            while(this.tam == this.tam_max){
                System.out.println("Buffer cheio!");
                this.naoCheio.await();
            }
            this.tam++;
            this.buffer[this.fim] = x;
            this.fim = (this.fim + 1) % this.tam_max;
            this.naoVazio.signal();
        } catch (InterruptedException ex) {
            System.out.print("erro na insercao");
        } finally{
            this.lock.unlock();
        }
    }
    
    public int remove(){
        int ret = 0;
        this.lock.lock();
        try{
            while(this.tam == 0){
                System.out.println("Buffer Vazio!");
                this.naoVazio.await();
            }
            this.tam--;
            ret = this.buffer[this.ini];
            this.ini = (this.ini + 1) %this.tam_max;
            this.naoCheio.signal();
        }catch (InterruptedException ex) {
            System.out.print("erro na insercao");
            
        }finally{
            this.lock.unlock();
        }
        return ret;
    }
}
