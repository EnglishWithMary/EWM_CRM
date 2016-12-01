package evg.testt.model;

/**
 * Created by DENNNN on 19.11.2016.
 */
public enum Pipe {
    LEAD_PIPE(1), STUDENT_PIPE(2);

    private int pipeId;

    Pipe (int id){
        pipeId = id;
    }

    public int getPipeId()
    {
        return pipeId;
    }

    public static Pipe valueOf (int index)
    {
        Pipe pipes[] = Pipe.values();
        return pipes[--index];
    }
}