package thread.start;

import java.util.TreeMap;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        DaemonTread daemonTread = new DaemonTread();
        daemonTread.setDaemon(true);    // 데몬 스레드 여부 - main 스레드가 끝나면 jvm은 종료된다
        daemonTread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonTread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run() start");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
