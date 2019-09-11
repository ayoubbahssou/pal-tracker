package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private long id = 1L;

    private Map<Long, TimeEntry> listTimeEntry = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        if (timeEntry.getId() == 0) {
            timeEntry.setId(id++);
        }
        listTimeEntry.put(timeEntry.getId(), timeEntry);

        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return listTimeEntry.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(listTimeEntry.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (listTimeEntry.containsKey(id)) {
            timeEntry.setId(id);
            listTimeEntry.put(id, timeEntry);
            return timeEntry;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        listTimeEntry.remove(id);
    }
}
