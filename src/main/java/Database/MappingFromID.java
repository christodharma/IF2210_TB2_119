package Database;

import Model.HaveID;

import java.util.HashMap;
import java.util.HashSet;

public interface MappingFromID<T extends HaveID> {
    default HashMap<String, T> toMap(HashSet<T> Set){
        HashMap<String, T> ret = new HashMap<>();
        for (T setElem :
                Set) {
            ret.put(setElem.getID(), setElem);
        }
        return ret;
    }
}
