import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyThread extends Thread {
    private final Mutex mutex;
    public String cmd;
    public static int counter=0;
    private Process process;
    private BufferedReader bufferedReaderInput;
    private BufferedReader bufferedReaderError;
    public String title;
    public boolean isRunning=false;

//    public boolean isFinished=false;

    public MyThread(String cmd, String title) throws IOException {
        this.mutex = new Mutex(false);
        this.cmd = cmd;
        this.title = title;
//        this.process = Runtime.getRuntime().exec(this.cmd);
//        this.bufferedReaderInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        this.bufferedReaderError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        MyThread.counter+=1;
    }

    public void ProcessRun() throws IOException, IllegalThreadStateException{
        try{
            this.process = Runtime.getRuntime().exec(this.cmd);
            this.bufferedReaderInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            this.bufferedReaderError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            this.start();
        } catch (IllegalThreadStateException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex.getStackTrace());
            System.err.println(ex.getCause());
            ex.printStackTrace();
        }
    }

    public void ProcessStop() throws IOException, InterruptedException {
        long pid = this.process.pid();
        String os = getOperatingSystem();
        Process processKill;

        if(os.contains("Linux") || os.contains("Mac")){
            processKill = Runtime.getRuntime().exec("kill -9 "+pid);
        }else{
            //Windows
            //Taskkill /F /PID pid_number
            processKill = Runtime.getRuntime().exec("Taskkill /F /PID "+pid);
        }

        this.isRunning=false;
        processKill.waitFor();
        this.interrupt();
    }

    public String getOperatingSystem() {
        String os = System.getProperty("os.name");
//        System.out.println("Using System Property: " + os);
        return os;
    }

    public Mutex getMutex() {
        return this.mutex;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            mutex.step();

            // do your code
//            if(!this.isAlive() && this.isRunning==true){
//                this.isFinished = true;
//            }else{
//                this.isFinished=false;
//            }

            try {
                this.isRunning=true;
                process.waitFor();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            while (true) {
                try {
                    if (!bufferedReaderError.ready()){
                        this.interrupt();
                        break;
                    }
                    else{
                        System.err.println(bufferedReaderError.readLine());
                     }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            while (true) {
                try {
                    if (!bufferedReaderInput.ready()){
                        this.interrupt();
                        break;
                    }
                    else{
                        System.out.println(bufferedReaderInput.readLine());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
}