Car entity = dataManager.load(Car.class).id(carId).dynamicAttributes(true).one;

Double capacity = entity.getValue("+loadCapacity");
entity.setValue("+loadCapacity", capacity + 10);

dataManager.commit(entity);