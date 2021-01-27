package concurrent;

public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (; i < 1000000; i++) {
                    i++;
                }
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });

        System.out.println(Thread.currentThread());
        System.out.println(thread);

        thread.start();

        Test01 test01 = new Test01();
        test01.getHello();

        thread.join();
        System.out.println("end");
    }

}

class Test01 {
    String name;

    public void getHello() {
        System.out.println(Thread.currentThread());
    }
}
