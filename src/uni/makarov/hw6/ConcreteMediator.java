package uni.makarov.hw6;

public class ConcreteMediator extends Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;
    private ConcreteColleague3 colleague3;
    public ConcreteColleague1 setColleague1(ConcreteColleague1 value) {
        colleague1 = value;
        return colleague1;
    }
    public ConcreteColleague2 setColleague2(ConcreteColleague2 value) {
        colleague2 = value;
        return colleague2;
    }
    public ConcreteColleague3 setColleague3(ConcreteColleague3 value) {
        colleague3 = value;
        return colleague3;
    }
    @Override
    public void Send(String message, Colleague colleague) {
        if (colleague == colleague1)
        {
            colleague2.notify(message);
        }
        else if (colleague == colleague2)
        {
            colleague1.notify(message);
        }
        else
        {
            colleague3.notify(message);
        }

    }
}
