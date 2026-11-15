package itemsadder.m;

import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.OptionalDynamic;
import java.util.Optional;
import java.util.Set;
import java.util.function.UnaryOperator;
import net.minecraft.util.datafix.schemas.NamespacedSchema;

public class Count_13 {
    private final String afd;
    private final int afe;
    private Dynamic adl;
    private final Dynamic aff;
    Dynamic adn;

    public Count_13(String string, int n, Dynamic dynamic) {
        this.afd = NamespacedSchema.ensureNamespaced((String)string);
        this.afe = n;
        this.adl = dynamic.emptyMap();
        this.adn = dynamic.get("tag").orElseEmptyMap();
        this.aff = dynamic.remove("tag");
    }

    public static Optional r(Dynamic dynamic) {
        return dynamic.get("id").asString().apply2stable((string, number) -> new Count_13((String)string, number.intValue(), dynamic.remove("id").remove("Count")), dynamic.get("Count").asNumber()).result();
    }

    public OptionalDynamic dG(String string) {
        OptionalDynamic optionalDynamic = this.adn.get(string);
        this.adn = this.adn.remove(string);
        return optionalDynamic;
    }

    public void a(String string, Dynamic dynamic) {
        this.adl = this.adl.set(string, dynamic);
    }

    public void a(String string, OptionalDynamic optionalDynamic) {
        optionalDynamic.result().ifPresent(dynamic -> {
            this.adl = this.adl.set(string, dynamic);
        });
    }

    public Dynamic a(String string, Dynamic dynamic, String string2) {
        Optional optional = this.dG(string).result();
        return optional.isPresent() ? dynamic.set(string2, (Dynamic)optional.get()) : dynamic;
    }

    public void a(String string, String string2, Dynamic dynamic) {
        Optional optional = this.dG(string).result();
        if (optional.isPresent() && !((Dynamic)optional.get()).equals((Object)dynamic)) {
            this.a(string2, (Dynamic)optional.get());
        }
    }

    public void O(String string, String string2) {
        this.dG(string).result().ifPresent(dynamic -> this.a(string2, (Dynamic)dynamic));
    }

    public void a(String string, boolean bl, UnaryOperator unaryOperator) {
        OptionalDynamic optionalDynamic = this.adn.get(string);
        if (!bl || !optionalDynamic.result().isEmpty()) {
            Dynamic dynamic = optionalDynamic.orElseEmptyMap();
            this.adn = (dynamic = (Dynamic)unaryOperator.apply(dynamic)).equals((Object)dynamic.emptyMap()) ? this.adn.remove(string) : this.adn.set(string, dynamic);
        }
    }

    public Dynamic tY() {
        Dynamic dynamic = this.adn.emptyMap().set("id", this.adn.createString(this.afd)).set("count", this.adn.createInt(this.afe));
        if (!this.adn.equals((Object)this.adn.emptyMap())) {
            this.adl = this.adl.set("minecraft:custom_data", this.adn);
        }
        if (!this.adl.equals((Object)this.adn.emptyMap())) {
            dynamic = dynamic.set("components", this.adl);
        }
        return Count_13.b(dynamic, this.aff);
    }

    private static Dynamic b(Dynamic dynamic, Dynamic dynamic2) {
        DynamicOps dynamicOps = dynamic.getOps();
        return dynamicOps.getMap(dynamic.getValue()).flatMap(mapLike -> dynamicOps.mergeToMap(dynamic2.convert(dynamicOps).getValue(), mapLike)).map(object -> new Dynamic(dynamicOps, object)).result().orElse(dynamic);
    }

    public boolean dH(String string) {
        return this.afd.equals(string);
    }

    public boolean f(Set set) {
        return set.contains(this.afd);
    }
}
