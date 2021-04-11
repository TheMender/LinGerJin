package Command;

import lombok.Data;

public abstract class Command {
    Context c;

    abstract public void doit();

    abstract public void undo();
}
