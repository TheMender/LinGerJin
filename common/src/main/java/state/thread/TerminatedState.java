package state.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TerminatedState extends ThreadState_ {
    private Tread_ t;


    @Override
    void move(Action action) {
        if (action.name == "Running") {
            t.newState = new RunningState(t);
        }

    }

    @Override
    void run() {

    }
}
