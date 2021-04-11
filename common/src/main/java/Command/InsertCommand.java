package Command;

import lombok.Data;

@Data
public class InsertCommand extends Command {

    String strInfo = "test!!!";

    public InsertCommand(Context c) {
        this.c = c;
    }

    @Override
    public void doit() {
        c.msg = c.msg + strInfo;
    }

    @Override
    public void undo() {
        c.msg.substring(0, c.msg.length() - strInfo.length());
    }
}
