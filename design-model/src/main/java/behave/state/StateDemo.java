package behave.state;

/**
 * 状态模式<br>
 * 对象的行为根据对象的状态发生变化，如在这些方法中暴力if-else，其不符合开闭原则；<br>
 * 可使用状态模式，将相应的状态抽象出一个对象，不同状态对应不同实现。
 * 
 * @author 22517
 *
 */
public class StateDemo {
    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        context.start();
        context.getCpu();
        context.start();// 1
        context.suspend();
        context.resume();
        context.stop();
    }
}

class ThreadContext {
    private ThreadState state;

    public ThreadContext() {
        super();
        this.state = new CreatedState(this);
    }

    void start() {
        state.start();
    }

    void getCpu() {
        state.getCpu();
    }

    void suspend() {
        state.suspend();
    }

    void resume() {
        state.resume();
    }

    void stop() {
        state.stop();
    }

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

}

interface ThreadState {
    void start();

    void getCpu();

    void suspend();

    void resume();

    void stop();
}

class CreatedState implements ThreadState {
    ThreadStateName threadStateName = ThreadStateName.CREATED;
    ThreadContext context;

    public CreatedState(ThreadContext context) {
        super();
        this.context = context;
    }

    @Override
    public void start() {
        System.out.println("当前：" + threadStateName.getName() + "，进入就绪");
        context.setState(new ReadyState(context));
    }

    @Override
    public void getCpu() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许运行");
    }

    @Override
    public void suspend() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许挂起");
    }

    @Override
    public void resume() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许恢复");
    }

    @Override
    public void stop() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许销毁");
    }

}

class ReadyState implements ThreadState {

    ThreadStateName threadStateName = ThreadStateName.READY;
    ThreadContext context;

    public ReadyState(ThreadContext context) {
        super();
        this.context = context;
    }

    @Override
    public void start() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许进入就绪");
    }

    @Override
    public void getCpu() {
        System.out.println("当前：" + threadStateName.getName() + "，进入运行");
        context.setState(new RunningState(context));
    }

    @Override
    public void suspend() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许挂起");
    }

    @Override
    public void resume() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许恢复");
    }

    @Override
    public void stop() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许销毁");
    }
}

class RunningState implements ThreadState {
    ThreadStateName threadStateName = ThreadStateName.RUNNING;
    ThreadContext context;

    public RunningState(ThreadContext context) {
        super();
        this.context = context;
    }

    @Override
    public void start() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许进入就绪");
    }

    @Override
    public void getCpu() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许运行");
    }

    @Override
    public void suspend() {
        System.out.println("当前：" + threadStateName.getName() + "，进入挂起");
        context.setState(new BlockState(context));
    }

    @Override
    public void resume() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许恢复");
    }

    @Override
    public void stop() {
        System.out.println("当前：" + threadStateName.getName() + "，进入销毁");
        context.setState(new StopState(context));
    }

}

class BlockState implements ThreadState {

    ThreadStateName threadStateName = ThreadStateName.BLOCK;
    ThreadContext context;

    public BlockState(ThreadContext context) {
        super();
        this.context = context;
    }

    @Override
    public void start() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许进入就绪");
    }

    @Override
    public void getCpu() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许运行");
    }

    @Override
    public void suspend() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许挂起");
    }

    @Override
    public void resume() {
        System.out.println("当前：" + threadStateName.getName() + "，恢复到就绪");
        context.setState(new ReadyState(context));
    }

    @Override
    public void stop() {
        System.out.println("当前：" + threadStateName.getName() + "，进入销毁");
        context.setState(new StopState(context));
    }
}

class StopState implements ThreadState {

    ThreadStateName threadStateName = ThreadStateName.STOP;
    ThreadContext context;

    public StopState(ThreadContext context) {
        super();
        this.context = context;
    }

    @Override
    public void start() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许进入就绪");
    }

    @Override
    public void getCpu() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许运行");
    }

    @Override
    public void suspend() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许挂起");
    }

    @Override
    public void resume() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许恢复");
    }

    @Override
    public void stop() {
        System.out.println("当前：" + threadStateName.getName() + "，不允许销毁");
    }
}

enum ThreadStateName {
    CREATED("新建"), READY("就绪"), RUNNING("运行"), BLOCK("阻塞"), STOP("销毁");
    private String name;

    private ThreadStateName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}