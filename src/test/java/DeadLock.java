public class DeadLock {

    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Thread t1 = new Thread(()->{
            synchronized (lockA) {
                System.out.println("t1获得了锁A");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println("t1获得了锁B");
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (lockB) {
                System.out.println("t2获得了锁B");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.println("t2获得了锁A");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
