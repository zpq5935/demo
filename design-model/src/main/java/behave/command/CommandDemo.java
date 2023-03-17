package behave.command;
/**
 * 命令模式<br>
 * 类似于策略模式，旨为命令发送与命令执行解耦。不同命名完成不同功能。
 * @author 22517
 *
 */
public class CommandDemo {

}

/**
 * 家电的各种命令
 * @author 22517
 *
 */
interface Command{
    void execute();
}

/**
 * 智能遥控器
 * @author 22517
 *
 */
class Controler{
    
}