LoadContext lc = new LoadContext(Car.class).setId(id);
lc.setLoadDynamicAttributes(true);
Entity entity = dataManager.load(lc);

Double capacity = entity.getValue("+loadCapacity");
entity.setValue("+loadCapacity", capacity + 10);

dataManager.commit(entity);