
class ThreadCreation implements  Runnable{
    public void run()
    {
       try
       {
           System.out.println(" "+ Thread.currentThread().getName());
           Thread.sleep(1000);
           System.out.println(Thread.currentThread().getState());
       }
       catch (InterruptedException ex){
           ex.printStackTrace();
       }
        System.out.println(" in run method ; thread name is : " + Thread.currentThread().getName());

    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
          Thread mythread = new Thread();
        System.out.println(mythread);

        mythread.start();
        System.out.println(Thread.currentThread().getName() + " Currently in " + mythread.getState());
    }
}