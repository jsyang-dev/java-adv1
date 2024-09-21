package thread.start;

import static util.MyLogger.*;

public class StartTest4Main {
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyRunnable("A", 1000), "Thread-A");
        threadA.start();

        Thread threadB = new Thread(new MyRunnable("B", 500), "Thread-B");
        threadB.start();
    }

    static class MyRunnable implements Runnable {
        private final String content;
        private final long sleepMillis;

        public MyRunnable(String content, long sleepMillis) {
            this.content = content;
            this.sleepMillis = sleepMillis;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
