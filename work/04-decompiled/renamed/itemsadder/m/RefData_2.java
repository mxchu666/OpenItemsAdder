package itemsadder.m;

import itemsadder.m.IaitemCommand;
import java.util.ArrayList;

class RefData_2
extends ArrayList {
    final /* synthetic */ IaitemCommand SD;

    RefData_2(IaitemCommand iaitemCommand) {
        this.SD = iaitemCommand;
        this.add("--player");
        this.add("--slot");
        this.add("--item");
    }
}
