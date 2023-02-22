package zpq.cycle;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class D {

//    @Transactional
    public String say() {
        System.out.println(D.class.getCanonicalName());
        return D.class.toString();
    }

//    @Transactional
    private String say1() {
        System.out.println(D.class.getCanonicalName());
        return D.class.toString();
    }
}
