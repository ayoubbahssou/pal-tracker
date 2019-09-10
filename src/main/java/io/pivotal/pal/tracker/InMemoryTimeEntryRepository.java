package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private List<TimeEntry> listTimeEntry = new ArrayList<>();
   private  Long idCount = 1L;
    @Override
    public TimeEntry create(TimeEntry timeEntry) {

            timeEntry.setId(idCount);
        idCount+=1;
        listTimeEntry.add(timeEntry);
        return timeEntry;
    }


    @Override
    public TimeEntry find(long id) {
        //return (TimeEntry) listTimeEntry.stream().filter(timeEntry -> timeEntry.getId()==id);
        for(TimeEntry timeEntry : listTimeEntry){
            if(timeEntry.getId()==id){
                return timeEntry;
            }
        }

        return  null;

    }

    @Override
    public List<TimeEntry> list() {
        return listTimeEntry;
    }
    @Override
    public  void delete(long id) {
        TimeEntry timeEntry = this.find(id);
        if(timeEntry!=null)
        listTimeEntry.remove(timeEntry);
    }
    @Override
    public TimeEntry update(long l, TimeEntry timeEntry) {
        //this.delete(l);
        TimeEntry timeEntree = this.find(l);
        if(timeEntree!=null) {
            timeEntry.setId(timeEntree.getId());
            listTimeEntry.remove(timeEntree);
            listTimeEntry.add(timeEntry);
            return timeEntry;
        }
        return null;
    }

}
