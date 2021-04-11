package Command;

public class CommandMain {
    public static void main(String[] args) {
        Context c =new Context("wocao");
        Command command = new InsertCommand(c);
        command.doit();;
        System.out.println(command.c.msg);
    }
}
