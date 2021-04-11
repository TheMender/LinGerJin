package state.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewState extends ThreadState_ {
    private Tread_ t;

    @Override
    void move(Action action) {
        if (action.name == "Ter") {
            t.newState = new NewState(t);
        }

    }

    @Override
    void run() {

    }
}