import java.util.LinkedList;
import java.util.Queue;

public class CarQueue {

    Queue<Integer> directionQueue;

    CarQueue(){
        directionQueue = new LinkedList<Integer>();
        for(int i = 0; i < 5; i++) {
            directionQueue.add(getRandom());
        }
    }

    // Adds 0,1,2 or 3 to queue

    void addToQueue(){


        class RandomThread implements Runnable {
            public void run(){
                try {
                    while(true) {
                        directionQueue.add(getRandom());
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {

                }
            }
        }

        RandomThread rThread = new RandomThread();
        Thread randomGenThread = new Thread(rThread);
        randomGenThread.start();

    }


    //delete the queue
    int deleteQueue(){
        return directionQueue.poll();
    }

    //get random number
    static int getRandom() {
        return (int) (Math.random() * 4);
    }

}