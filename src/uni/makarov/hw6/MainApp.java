package uni.makarov.hw6;

import java.lang.reflect.Constructor;

public class MainApp {

    //Mediator
    static abstract class Mediator {
        public abstract void send(String message, Colleague colleague);
    }

    //ConcreteMediatior
    static class ConcreteMediator extends Mediator {
        private ConcreteColleague1 colleague1;
        private ConcreteColleague2 colleague2;
        private ConcreteColleague3 colleague3;

        public void setColleague1(ConcreteColleague1 c1) {
            colleague1 = c1;
        }

        public void setColleague2(ConcreteColleague2 c2) {
            colleague2 = c2;
        }

        public void setColleague3(ConcreteColleague3 c3) {
            colleague3 = c3;
        }
        @Override
        public void send(String message, Colleague colleague) {
            if (colleague == colleague1) {
                colleague1.notify(message);
            }

            if (colleague == colleague2) {
                colleague2.notify(message);
            }

            if (colleague == colleague3) {
                colleague3.notify(message);
            }
        }
    }

    //Colleague
    static abstract class Colleague {
        protected Mediator mediator;

        //Constructor
        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }
    }

    //ConcreteColleague1
    static class ConcreteColleague1 extends Colleague {
        //Constructor
        public ConcreteColleague1(Mediator mediator) {
            super(mediator);
        }

        public void send(String message) {
            mediator.send(message, this);
        }

        public void notify(String message) {
            System.out.println("Colleague1 gets message: " + message);
        }
    }

    //ConcreteColleague2
    static class ConcreteColleague2 extends Colleague {
        //Constructor
        public ConcreteColleague2(Mediator mediator) {
            super(mediator);
        }

        public void send(String message) {
            mediator.send(message, this);
        }

        public void notify(String message) {
            System.out.println("Colleague2 gets message: " + message);
        }
    }

    static class ConcreteColleague3 extends Colleague {
        //Constructor
        public ConcreteColleague3(Mediator mediator) {
            super(mediator);
        }

        public void send(String message) {
            mediator.send(message, this);
        }

        public void notify(String message) {
            System.out.println("Colleague3 gets message: " + message);
        }
    }

    public static void main(String[] args) {
            ConcreteMediator m = new ConcreteMediator();
            ConcreteColleague1 c1 = new ConcreteColleague1(m);
            ConcreteColleague2 c2 = new ConcreteColleague2(m);
            ConcreteColleague3 c3 = new ConcreteColleague3(m);

            m.setColleague1(c1);
            m.setColleague2(c2);
            m.setColleague3(c3);

            m.send("How are you?", c1);
            m.send("Fine, thanks", c2);
            m.send("Hello!", c3);

    }
}
