import java.util.concurrent.atomic.AtomicBoolean;

public class Mutex {
    private final AtomicBoolean lock;
    private final Object mutex;
    public boolean IsLocked;

    public Mutex(boolean lock) {
        this.lock = new AtomicBoolean(lock);
        this.IsLocked = false;
        this.mutex = new Object();
    }

    public void step() {
        if (lock.get()) synchronized(mutex) {
            try {
                mutex.wait();
            } catch (InterruptedException ex) {}
        }
    }

    public void lock() {
        lock.set(true);
        this.IsLocked = true;
    }

    public void unlock() {
        lock.set(false);
        this.IsLocked = false;

        synchronized(mutex) {
            mutex.notify();
        }
    }
}