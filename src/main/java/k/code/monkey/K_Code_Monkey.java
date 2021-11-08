package k.code.monkey;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class K_Code_Monkey {

    private final Monkey aMonkey;
    private final Monkey bMonkey;
    private final Monkey cMonkey;

    private final Tiger  tigerGuest;

    public K_Code_Monkey() {
        this.aMonkey = new Monkey(12, false, Arrays.asList("잉여"));
        this.bMonkey = new Monkey(9, false, Arrays.asList("오락부장", "디아블로", "FM"));
        this.cMonkey = new Monkey(5, true, Arrays.asList("Chief Monkey", "어쩌다 Ace", "어쩌다 슈퍼루키"));

        this.tigerGuest = new Tiger(30, Arrays.asList("엄격", "근엄", "진지", "미남", "화면에 안나옴"));
    }

    @Getter
    static class Monkey{
        private final Integer old;
        private final Boolean unavailable;
        private final List<String> values;

        Monkey(Integer old, Boolean unavailable, List<String> values) {
            this.old = old;
            this.unavailable = unavailable;
            this.values = values;
        }
    }

    @Getter
    static class Tiger{
        private final Integer old;
        private final List<String> values;

        Tiger(Integer old, List<String> values) {
            this.old = old;
            this.values = values;
        }
    }
}
