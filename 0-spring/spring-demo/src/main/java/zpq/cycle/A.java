package zpq.cycle;

public class A {
    String name;
    B b;

    public void say() {
//        A proxy = (A)AopContext.currentProxy();
        System.out.println(name);
//        proxy.sayInner();
    }

    private void sayInner() {
        System.out.println("sayInner：" + name);
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
