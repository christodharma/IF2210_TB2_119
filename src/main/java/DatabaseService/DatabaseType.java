package DatabaseService;

import lombok.Setter;

public class DatabaseType{
    protected Class<?> _class;
    public void set_class(Class<?> set){
        _class = set;
    }
    public void reset(){_class=null;}
    public DatabaseType(Class<?> dataClass) {
        _class = dataClass;
    }
    public DatabaseType (Object data) {
        _class = data.getClass();
    }
}
