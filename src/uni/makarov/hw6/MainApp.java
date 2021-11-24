package uni.makarov.hw6;

import java.lang.reflect.Constructor;

public class MainApp {
    public static void main(String[] args) {
        ConcreteMediator m = new ConcreteMediator();
        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);
        ConcreteColleague3 c3 = new ConcreteColleague3(m);
        m.setColleague1(c1);
        m.setColleague2(c2);
        m.setColleague3(c3);
        m.Send("How are you?", c1);
        m.Send("Fine, thanks", c2);
        m.Send("Hello!", c3);
    }
}
