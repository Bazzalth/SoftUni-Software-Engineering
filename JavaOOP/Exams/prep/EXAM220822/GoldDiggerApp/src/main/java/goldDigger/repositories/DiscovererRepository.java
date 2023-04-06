package goldDigger.repositories;

import goldDigger.models.discoverer.Discoverer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiscovererRepository implements Repository<Discoverer> {
    private Map<String, Discoverer> discoverers;

    public DiscovererRepository() {
        this.discoverers = new LinkedHashMap<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(discoverers.values());
    }

    @Override
    public void add(Discoverer entity) {
        discoverers.put(entity.getName(), entity);
    }

    @Override
    public boolean remove(Discoverer entity) {
        boolean isRemoved = discoverers.values().remove(entity);
        return isRemoved;
    }

    @Override
    public Discoverer byName(String name) {
        return discoverers.values()
                .stream()
                .filter(discoverer -> discoverer.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}