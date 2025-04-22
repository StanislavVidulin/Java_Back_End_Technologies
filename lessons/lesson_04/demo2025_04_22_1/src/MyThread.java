public class MyThread extends Thread{
    // volatile - переменная, которая может измениться из другого потока
    // volatile вместо synchronized в isFinish и setFinish
    private volatile boolean isFinish = false;
    private int counter = 0;

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        System.out.println("Thread start");
        // while(!isFinish) - это неправильно, переменная не знает что поменялся финиш, а метод знает
        // while(!isFinish())
        // while(!isFinish) - теперь знает из-за volatile
        while (!isFinish){
            counter++;
//            if (counter%1000==0) {
//                System.out.println(isFinish);
//            }  -  работает без volatile
        }
        System.out.println("Thread finish " + counter);
    }
}
