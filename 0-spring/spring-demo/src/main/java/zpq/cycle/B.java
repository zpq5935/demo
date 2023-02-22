package zpq.cycle;

import org.springframework.stereotype.Component;

@Component
public class B {
    String name;
    A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
