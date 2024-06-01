package test.ch2;

import java.util.ArrayList;
import java.util.List;

public class SUT {

    private String systemName;
    private boolean isVerified;
    private List<Job> jobs = new ArrayList<>();
    private Job currentJob;



    public SUT() {
    }

    public SUT(String systemName) {
        this.systemName = systemName;
        this.isVerified=false;
        System.out.println(systemName + " из класса " + getClass().getSimpleName() + " инициализируется.");
    }

    public boolean canReceiveRegularWork() {
        System.out.println(systemName + " из класса " + getClass().getSimpleName() + " может получить постоянную работу.");
        return true;
    }

    public boolean canReceiveAdditionalWork() {
        System.out.println(systemName + " из класса " + getClass().getSimpleName() + " не может получить дополнительную работу.");
        return false;
    }

    public void close() {
        System.out.println(systemName + " из класса " + getClass().getSimpleName() + " закрывается.");
    }


    public String hello() {
        return "Привет!";
    }

    public String bye() {
        return "Пока!";
    }

    public String talk() {
        return "Как дела?";
    }

    public String getSystemName() {
        return systemName;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void verify() {
        this.isVerified = true;
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public Object[] getJobsAsArray() {
        return jobs.toArray();
    }

    public void run() {
        if (jobs.size() > 0) {
            currentJob = jobs.remove(0);
            System.out.println("Выполнение задания: " + currentJob);
            return;
        }
        throw new NoJobException("В списке выполнения нет заданий!");
    }

    public void run(int jobDuration) throws InterruptedException {
        if (jobs.size() > 0) {
            currentJob = jobs.remove(0);
            System.out.println("Выполнение задания: " + currentJob + " длиться " + jobDuration + " миллисекунды");
            Thread.sleep(jobDuration);
            return;
        }
        throw new NoJobException("В списке выполнения нет заданий!");
    }
}
