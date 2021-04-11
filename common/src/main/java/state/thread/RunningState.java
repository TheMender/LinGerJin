package state.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RunningState extends ThreadState_ {
    private Tread_ t;

    @Override
    void move(Action action) {
        if (action.name == "Start") {
            t.newState = new TerminatedState(t);
        }

    }

    @Override
    void run() {

    }
}
