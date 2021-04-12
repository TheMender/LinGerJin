package visitor;

public class Computer {
    ComputerPart cpu = new Cpu();
    ComputerPart brand = new Brand();
    ComputerPart memory = new Memory();

    public void accpet(Visotor v) {
        this.cpu.accpet(v);
        this.brand.accpet(v);
        this.memory.accpet(v);
    }

    public static void main(String[] args) {
        PersonalVisitor personalVisitor = new PersonalVisitor();
        new Computer().accpet(personalVisitor);
        System.out.println(personalVisitor.totalPrice);

        CorpVisotor corpVisotor = new CorpVisotor();
        new Computer().accpet(corpVisotor);
        System.out.println(corpVisotor.totalPrice);
    }

}

abstract class ComputerPart {
    abstract void accpet(Visotor v);

    abstract double getPrice();
}

class Cpu extends ComputerPart {


    @Override
    void accpet(Visotor v) {
        v.visitCpu(this);
    }

    @Override
    double getPrice() {
        return 20;
    }
}

class Brand extends ComputerPart {


    @Override
    void accpet(Visotor v) {
        v.visitBrand(this);

    }

    @Override
    double getPrice() {
        return 10;
    }
}

class Memory extends ComputerPart {

    @Override
    void accpet(Visotor v) {
        v.visitMemory(this);
    }


    @Override
    double getPrice() {
        return 40;
    }
}

interface Visotor {
    void visitCpu(Cpu cpu);

    void visitBrand(Brand brand);

    void visitMemory(Memory memory);
}

class PersonalVisitor implements Visotor {
    double totalPrice = 0.0;
    double discount = 0.7;

    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice() * discount;
    }

    @Override
    public void visitBrand(Brand brand) {
        totalPrice += brand.getPrice() * discount;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * discount;

    }
}

class CorpVisotor implements Visotor {
    double totalPrice = 0.0;
    double discount = 0.9;

    @Override
    public void visitCpu(Cpu cpu) {
        totalPrice += cpu.getPrice() * discount;
    }

    @Override
    public void visitBrand(Brand brand) {
        totalPrice += brand.getPrice() * discount;
    }

    @Override
    public void visitMemory(Memory memory) {
        totalPrice += memory.getPrice() * discount;

    }
}