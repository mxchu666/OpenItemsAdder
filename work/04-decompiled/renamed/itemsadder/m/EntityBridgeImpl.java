package itemsadder.m;

import itemsadder.m.EntityBridge;
import itemsadder.m.EntityBridgeBuilderImpl;
import itemsadder.m.EventWrapper;
import lombok.Generated;

public abstract class EntityBridgeImpl
extends EntityBridge
implements EventWrapper {
    @Generated
    protected EntityBridgeImpl(EntityBridgeBuilderImpl entityBridgeBuilderImpl) {
        super(entityBridgeBuilderImpl);
    }
}
